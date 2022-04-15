//package com.nhnacademy.edu.springframework.project.repository;
//
//import com.nhnacademy.edu.springframework.project.service.CsvDataLoadService;
//import java.io.IOException;
//import java.util.Collection;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.Csv;
//
//import static org.assertj.core.api.Assertions.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ScoresTest {
//
//    @Test
//    void load() throws IOException {
//        CsvScores.getInstance().load();
//
//        assertThat(CsvScores.getInstance()).isNotNull();
//    }
//
//    @Test
//    void findAll() throws IOException {
//        CsvScores.getInstance().load();
//        Collection student = CsvScores.getInstance().findAll();
//
//        assertThat(student).isNotEmpty();
////        assertThat(student.size()).isEqualTo()
//
//    }
//
//    @DisplayName("load() 전에 findAll() 실행할 경우 예외 발생")
//    @Test
//    void findAll_beforeLoad_thenThrowException() {
//
//        assertThatIllegalStateException().isThrownBy(() ->CsvScores.getInstance().findAll())
//            .withMessageContaining("illegal");
//    }
//}