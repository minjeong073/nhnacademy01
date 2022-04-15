//package com.nhnacademy.edu.springframework.project.repository;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.assertj.core.api.Assertions.*;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//class StudentTest {
//
//    @Test
//    void merge() {
//
//    }
//
//    @DisplayName("모든 값이 Collection<Score> scores 에 들어왔는지 확인")
//    @Test
//    void load_and_findAll() throws IOException {
//        CsvStudents.getInstance().load();
//        CsvScores.getInstance().load();
//
//        //csv 파일에서 직접 가져온 list
//       List<Score> scoreList = new ArrayList<>();
//        String filepath = "src/main/resources/data/score.csv";
//        BufferedReader bufferedReader = null;
//        String line = "";
//        try {
//            bufferedReader = new BufferedReader(new FileReader(filepath));
//
//            while((line = bufferedReader.readLine()) != null) {
//                String[] arr = line.split(",");
//                scoreList.add(new Score(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //findAll() 로 가져온 Score
//        Collection<Score> scores = CsvScores.getInstance().findAll();
//        CsvStudents.getInstance().merge(scores);
//
//        assertThat(scores).isNotEmpty();
//        assertThat(scores.size()).isEqualTo(scoreList.size());
//    }
//
//    @DisplayName("load() 전에 findAll() 실행할 경우 예외 발생")
//    @Test
//    void findAll_beforeLoad_thenThrowException() {
//
//        assertThatIllegalStateException().isThrownBy(() ->CsvStudents.getInstance().findAll())
//            .withMessageContaining("illegal");
//    }
//
//}