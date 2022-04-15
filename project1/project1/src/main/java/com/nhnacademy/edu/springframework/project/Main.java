package com.nhnacademy.edu.springframework.project;

import com.nhnacademy.edu.springframework.project.config.MainConfiguration;
import com.nhnacademy.edu.springframework.project.service.CsvDataLoadService;
import com.nhnacademy.edu.springframework.project.service.DataLoadService;
import com.nhnacademy.edu.springframework.project.service.DefaultStudentService;
import com.nhnacademy.edu.springframework.project.repository.Student;

import com.nhnacademy.edu.springframework.project.service.StudentService;
import java.io.IOException;
import java.util.Collection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Log log = LogFactory.getLog(Main.class);
    public static void main(String[] args) throws IOException {

        log.warn("Main starting!");

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            MainConfiguration.class)) {
            DataLoadService dataLoadService = context.getBean("csvDataLoadService", DataLoadService.class);
            StudentService defaultStudentService = context.getBean("defaultStudentService", StudentService.class);

            dataLoadService.loadAndMerge();
            Collection<Student> passedStudents = defaultStudentService.getPassedStudents();
            System.out.println(passedStudents);

            Collection<Student> orderedStudents = defaultStudentService.getStudentsOrderByScore();
            System.out.println(orderedStudents);
        }



//        DataLoadService dataLoadService = new CsvDataLoadService();
//        dataLoadService.loadAndMerge();

//        DefaultStudentService studentService = new DefaultStudentService();
//        Collection<Student> passedStudents = studentService.getPassedStudents();
//        System.out.println(passedStudents);
//
//        Collection<Student> orderedStudents = studentService.getStudentsOrderByScore();
//        System.out.println(orderedStudents);
    }
}
