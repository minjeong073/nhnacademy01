//package com.nhnacademy.edu.springframework.project.service;
//
//import static org.assertj.core.api.Assertions.as;
//import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
//import static org.junit.jupiter.api.Assertions.*;
//
//import com.nhnacademy.edu.springframework.project.repository.CsvScores;
//import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
//import com.nhnacademy.edu.springframework.project.repository.Score;
//import java.io.IOException;
//import java.util.Collection;
//import java.util.List;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import static org.assertj.core.api.Assertions.assertThat;
//
//class DefaultGradeQueryServiceTest {
//
//    @BeforeEach
//    void setUp() throws IOException {
//        CsvStudents.getInstance().load();
//        CsvScores.getInstance().load();
//        Collection<Score> scores = CsvScores.getInstance().findAll();
//        CsvStudents.getInstance().merge(scores);
//    }
//
//    @DisplayName("이름이 A인 학생의 score 찾기")
//    @Test
//    void getScoreByStudentName() {
//        DefaultGradeQueryService gradeQueryService = new DefaultGradeQueryService();
//        List scores = gradeQueryService.getScoreByStudentName("A");
//
//        assertThat(scores.size()).isEqualTo(2);
//
//    }
//
//    @DisplayName("번호가 2인 학생의 score 찾기")
//    @Test
//    void getScoreByStudentSeq() {
//        DefaultGradeQueryService gradeQueryService = new DefaultGradeQueryService();
//        int seq = 2;
//        Score score = gradeQueryService.getScoreByStudentSeq(seq);
//
//        assertThat(score.getStudentSeq()).isEqualTo(seq);
//        assertThat(score.getScore()).isEqualTo(80);
//    }
//
//
//}