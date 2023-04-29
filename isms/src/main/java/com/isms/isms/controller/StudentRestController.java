package com.isms.isms.controller;

import com.isms.isms.entity.Student;
import com.isms.isms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    // expose "/Students" and return a list of Students
    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    // add mapping for GET /Students/{StudentId}

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        Student theStudent = studentService.findById(studentId);

        if (theStudent == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        return theStudent;
    }

    // add mapping for POST /Students - add new Student

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student theStudent) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theStudent.setId(0);

        Student dbStudent = studentService.save(theStudent);

        return dbStudent;
    }

    // add mapping for PUT /Students - update existing Student

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student theStudent) {

        Student dbStudent = studentService.save(theStudent);

        return dbStudent;
    }

    // add mapping for DELETE /Students/{StudentId} - delete Student

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {

        Student tempStudent = studentService.findById(studentId);

        // throw exception if null

        if (tempStudent == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        studentService.deleteById(studentId);

        return "Deleted Student id - " + studentId;
    }
}
