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
            Student madara = new Student("Madara", "madara@gmail.com", LocalDate.of(2000, Month.AUGUST, 24), 24);
            Student naruto = new Student("Naruto", "naruto@gmail.com", LocalDate.of(2000, Month.JULY, 10), 21);

            studentRepository.saveAll(List.of(madara, naruto));
        };
    }
}
