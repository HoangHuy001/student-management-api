package com.huydev.student_api.service;

import com.huydev.student_api.entity.Student;
import com.huydev.student_api.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // GET ALL
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // GET BY ID
    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // CREATE
    public Student createStudent(Student student) {
        return repository.save(student);
    }

    // UPDATE
    public Student updateStudent(Long id, Student updatedStudent) {
        Student student = repository.findById(id).orElse(null);

        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setAge(updatedStudent.getAge());
            return repository.save(student);
        }

        return null;
    }

    // DELETE
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}