package com.nhnacademy.edu.springframework.project.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CsvStudentsTest {

    @DisplayName("<load method test>")
    @Test
    void load() {
        CsvStudents csvStudents = new CsvStudents();
        csvStudents.load();
    }

    @Test
    void merge() throws IOException {
        CsvStudents csvStudents = new CsvStudents();
        CsvScores.getInstance().load();
        Collection<Score> scores = CsvScores.getInstance().findAll();

        csvStudents.load();
        csvStudents.merge(scores);
    }

//    @Test
//    void loadException() {
//
//        assertThatIllegalArgumentException().isThrownBy(() -> CsvStudents.getInstance().findAll())
//            .withMessageContaining("Illegal");
//
//    }
}