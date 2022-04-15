//package com.nhnacademy.edu.springframework.project.service;
//
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.*;
//
//import com.nhnacademy.edu.springframework.project.repository.CsvScores;
//import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
//import com.nhnacademy.edu.springframework.project.repository.Score;
//import com.nhnacademy.edu.springframework.project.repository.Scores;
//import com.nhnacademy.edu.springframework.project.repository.Student;
//import com.nhnacademy.edu.springframework.project.repository.Students;
//import java.io.IOException;
//import java.util.Collection;
//import java.util.Map;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.*;
//
//
//class DefaultStudentServiceTest {
//
//    @BeforeEach
//    void setUp() throws IOException {
//        CsvStudents.getInstance().load();
//        CsvScores.getInstance().load();
//
//        Students studentsRepository = CsvStudents.getInstance();
//        Collection<Score> scores = CsvScores.getInstance().findAll();
//        studentsRepository.merge(scores);
//    }
//
//    @DisplayName("pass한 학생이 'passStudents' Map 에 담겨있는지 확인")
//    @Test
//    void getPassedStudents() {
//
//        DefaultStudentService defaultStudentService = new DefaultStudentService();
//        Collection student = defaultStudentService.getPassedStudents();
//
//        assertThat(student).isNotEmpty();
//    }
//
//    //예외처리
//
//    @DisplayName("성적순으로 정렬해서 'result' list에 새로 넣은 값이 들어있는지 확인")
//    @Test
//    void getStudentsOrderByScore() {
//
//        DefaultStudentService defaultStudentService = new DefaultStudentService();
//        Collection result = defaultStudentService.getStudentsOrderByScore();
//
//        assertThat(result).isNotEmpty();
//    }
//
//    //예외처리
////    @DisplayName("'result' list에 없는 경우 예외 발생")
////    @Test
////    void orderByScore_hasNotInResultList_thenThrowException() {
////        DefaultStudentService defaultStudentService = new DefaultStudentService();
////        Collection result;
////
////        assertThatThrownBy(() -> result = defaultStudentService.getPassedStudents())
////            .isInstanceOf()
////    }
//
//}