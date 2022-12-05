package com.example.springboottutorial.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @GetMapping
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
