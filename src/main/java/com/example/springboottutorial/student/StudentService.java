package com.example.springboottutorial.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Madara",
                        "madara.uchiha@gmail.com",
                        LocalDate.of(1998, Month.FEBRUARY, 28),
                        25),
                new Student(
                        2L,
                        "Naruto Uzumaki",
                        "naruto.uzumaki@gmail.com",
                        LocalDate.of(1999, Month.JULY, 17),
                        23
                )
        );
    }
}
