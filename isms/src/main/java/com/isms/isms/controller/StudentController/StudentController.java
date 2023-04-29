package com.isms.isms.controller.StudentController;

import com.isms.isms.controller.Exceptions.ErrorResponse;
import com.isms.isms.controller.Exceptions.NotFoundException;
import com.isms.isms.entity.Student;
import com.isms.isms.service.StudentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // expose "/students" and return a list of students
    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    // add mapping for GET /students/{studentId}
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        Student theStudent = studentService.findById(studentId);

        if (theStudent == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        return theStudent;
    }

    // add mapping for POST /students - add new student

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student theStudent) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theStudent.setId(0);

        Student dbStudent = studentService.save(theStudent);

        return dbStudent;
    }

    // add mapping for PUT /students - update existing student

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student theStudent) {

        Student dbStudent = studentService.save(theStudent);

        return dbStudent;
    }

    // add mapping for DELETE /students/{studentId} - delete student

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {

        Student tempStudent = studentService.findById(studentId);

        // throw exception if null

        if (tempStudent == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        studentService.deleteById(studentId);

        return "Deleted student id - " + studentId;
    }

    // Add an exception handler using @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(NotFoundException exc) {

        // create a StudentErrorResponse

        ErrorResponse error = new ErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler ... to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exc) {

        // create a StudentErrorResponse
        ErrorResponse error = new ErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}


