package com.nhnacademy.edu.springframework.project.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


/** DONE 3 :
 * load 를 제외한 메소드 실행시
 * 데이터 로드가 완료되지 않으면 IllegalStateException 이 발생해야 한다.
 **/

/**
 * Done 7 :
 * singleton 클래스를 만드세요.
 */
public class CsvStudents implements Students {

    private static Students INSTANCE = new CsvStudents();

    private final Map<Integer,Student> students = new HashMap<>();

    public static Students getInstance() {
        return INSTANCE;
    }

    /**
     * Done 6 : student.csv 파일에서 데이터를 읽어 students 에 추가하는 로직을 구현하세요.
     */

    @Override
    public void load() {
        String filepath = "src/main/resources/data/student.csv";
        InputStream is = CsvStudents.class.getResourceAsStream(filepath);

        BufferedReader bufferedReader = null;
        String line = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(filepath));

            while((line = bufferedReader.readLine()) != null) {
                String[] stringArray = line.split(",");
                int studentNum = Integer.parseInt(stringArray[0]);
                Student student = new Student(studentNum, stringArray[1]);
                students.put(studentNum, student);

//                System.out.println(studentNum + " : " + students.get(studentNum));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Collection<Student> findAll() {
        if (students.isEmpty()) {
            throw new IllegalStateException("illegal state exception!");
        }
        return this.students.values();
    }

    /**
     * DONE 8 : students 데이터에 score 정보를 추가하세요.
     * @param scores
     */
    @Override
    public void merge(Collection<Score> scores) {
        // students map -> seq -> scores list 의 seq 와 비교
        // -> student 객체의 score에 데이터 추가

//        for (Score score : scores) {
//            students.get(score.getStudentSeq()).setScore(score);
//        }
        if (students.isEmpty()) {
            throw new IllegalStateException("illegal state exception");
        }

        scores.forEach(score -> students.get(score.getStudentSeq()).setScore(score));

//        System.out.println(students.entrySet());

    }
}
