package com.spring.controller;

import com.spring.exception.StudentNotFoundException;
import com.spring.model.Student;
import com.spring.repository.StudentRepository;
import com.spring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentsController {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;


    @PostMapping("/students")
    public void postStudent(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @PutMapping("/students/{id}")
    public void putStudent(@PathVariable long id, @RequestBody Student student) {
        studentRepository.save(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentRepository.deleteById(id);
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable long id) {
        try {
            return studentRepository
                    .findById(id)
                    .orElseThrow(StudentNotFoundException::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

}
