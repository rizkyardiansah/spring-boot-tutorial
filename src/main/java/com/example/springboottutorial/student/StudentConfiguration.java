package com.example.springboottutorial.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student madara = new Student("Madara", "madara@gmail.com", LocalDate.of(1998, Month.AUGUST, 24));
            Student naruto = new Student("Naruto", "naruto@gmail.com", LocalDate.of(2002, Month.JULY, 10));

            studentRepository.saveAll(List.of(madara, naruto));
        };
    }
}
