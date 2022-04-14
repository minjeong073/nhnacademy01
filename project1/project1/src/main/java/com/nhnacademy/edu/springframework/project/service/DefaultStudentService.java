package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.repository.Student;
import com.nhnacademy.edu.springframework.project.repository.Students;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class DefaultStudentService implements StudentService {

    @Override
    public Collection<Student> getPassedStudents() {
        Students studentRepository = CsvStudents.getInstance();
        // DONE 1 : pass 한 학생만 반환하도록 수정하세요.
        //studentRepo -> score -> getScore

        Collection<Student> students = studentRepository.findAll();
        Map<Integer, Student> passStudents = new HashMap<>();


        for (Student student :
            students) {
            if (!student.getScore().isFail()) {
                passStudents.put(student.getSeq(), student);
//                System.out.println(passStudents.toString());
            }
        }

        return passStudents.values();
    }

    @Override
    public Collection<Student> getStudentsOrderByScore() {
        Students studentRepository = CsvStudents.getInstance();
        // DONE 4 : 성적 순으로 학생 정보를 반환합니다.
        Collection<Student> students = studentRepository.findAll();

        List<Student> studentList = new ArrayList<>(students);
        List<Student> result = new ArrayList<>();

        studentList.stream()
            .sorted(Comparator.comparing((Student s) -> s.getScore().getScore()))
            .forEach(result::add);

        return result;
    }
}
