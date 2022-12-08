package com.example.springboottutorial.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email already taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudentById(long studentId) {
        boolean studentExist = studentRepository.existsById(studentId);

        if (!studentExist) {
            throw new IllegalStateException("Student with id " + studentId + " is not exist");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(long studentId, String name, String email) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (!studentOptional.isPresent()) {
            throw new IllegalStateException("Student with id " + studentId + " is not exist");
        }

        if (name != null && name.length() > 0 && !name.equals(studentOptional.get().getName())) {
            studentOptional.get().setName(name);
        }

        if (email != null && email.length() > 0 && !email.equals(studentOptional.get().getEmail())) {
            if (studentRepository.findStudentByEmail(email).isPresent()) {
                throw new IllegalStateException("Email already taken");
            }

            studentOptional.get().setEmail(email);
        }
    }
}
