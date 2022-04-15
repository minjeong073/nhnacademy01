package com.nhnacademy.edu.springframework.project.repository;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Repository;


/** DONE 2 :
 * load 를 제외한 메소드 실행시
 * 데이터 로드가 완료되지 않으면 IllegalStateException 이 발생해야 한다.
 **/
@Repository
public class CsvScores implements Scores {

//    private static final Scores INSTANCE = new CsvScores();

    private final List<Score> scores = new ArrayList<>();

    private CsvScores(){}

//    public static Scores getInstance() {
//        return INSTANCE;
//    }


    /**
     * DONE 5 : score.csv 파일에서 데이터를 읽어 scores 에 추가하는 로직을 구현하세요.
     *
     */
    @Override
    public void load() {
        Log log = null;
        String filepath = "C:\\Users\\kimmj\\IdeaProjects\\SpringFramework\\0412\\project1\\project1\\src\\main\\resources\\data\\score.csv";
        InputStream is = CsvScores.class.getResourceAsStream(filepath);

        BufferedReader bufferedReader = null;
        String line = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(filepath));

            while((line = bufferedReader.readLine()) != null) {
                String[] stringArray = line.split(",");
                Score score = new Score(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1]));
                scores.add(score);

//                System.out.println(score.getStudentSeq() + " : " + score.getScore());
            }
        } catch (IOException e) {
            log.error("fail to process file",e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    log.error("fail to process file", e);
                }
            }
        }
    }

    @Override
    public List<Score> findAll() {
        if (scores.isEmpty()) {
            throw new IllegalStateException("illegal state exception");
        }
        return this.scores;
    }


}

