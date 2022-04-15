package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.annotation.Timer;
import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class CsvDataLoadService implements DataLoadService {
    Scores scores;
    Students students;

    public CsvDataLoadService(Scores scores,
                              Students students) {
        this.scores = scores;
        this.students = students;
    }

    @Override
    public void loadAndMerge() throws IOException {
        scores.load();
        students.load();

        students.merge(scores.findAll());

//        CsvScores.getInstance().load();
//        CsvStudents.getInstance().load();
//
//        CsvStudents.getInstance().merge(CsvScores.getInstance().findAll());
    }
}
