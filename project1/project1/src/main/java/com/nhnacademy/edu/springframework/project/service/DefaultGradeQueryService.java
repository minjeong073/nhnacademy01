package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.annotation.Timer;
import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;

import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Student;
import com.nhnacademy.edu.springframework.project.repository.Students;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class DefaultGradeQueryService implements GradeQueryService {
    Students students;

    public DefaultGradeQueryService(
        Students students) {
        this.students = students;
    }

    @Override
    public List<Score> getScoreByStudentName(String name) {
        // DONE 5: 학생 이름으로 점수를 반환합니다. 동명이인 고려합니다.
//        Collection<Student> students = CsvStudents.getInstance().findAll();
        List<Score> scoreList = new ArrayList<>();

        for (Student student: students.findAll()
             ) {
            if (Objects.equals(student.getName(), name)) {
                scoreList.add(student.getScore());
//                System.out.println(student.getScore());
            }
        }
        return scoreList;
    }

    @Override
    public Score getScoreByStudentSeq(int seq) {
        // DONE 6 : 학생 번호로 점수를 반환합니다.
//        Collection<Student> students = CsvStudents.getInstance().findAll();

        for(Student student : students.findAll()) {
            if (Objects.equals(student.getSeq(), seq)) {
//                System.out.println(student.getScore());
                return student.getScore();
            }
        }
        return null;
    }
}
