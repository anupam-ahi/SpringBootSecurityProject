package org.example.springbootsecurityproject.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.example.springbootsecurityproject.model.Student;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(new Student(101, 87, "anupam"), new Student(102, 23, "navin")));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }
    @GetMapping("/csrf-token")
    public CsrfToken getCSRFToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping("/student")
    public List<Student> addStudent(@RequestBody Student student){
        students.add(student);
        return students;

    }
}
