package com.isms.isms.controller.CourseController;

import com.isms.isms.controller.ProfessorController.ProfessorErrorResponse;
import com.isms.isms.controller.ProfessorController.ProfessorNotFoundException;
import com.isms.isms.entity.Courses;
import com.isms.isms.entity.Professor;
import com.isms.isms.service.CourseService.CourseService;
import com.isms.isms.service.ProfessorService.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // expose "/courses" and return a list of courses
    @GetMapping("/courses")
    public List<Courses> findAll() {
        return courseService.findAll();
    }

    // add mapping for GET /courses/{courseId}
    @GetMapping("/courses/{courseId}")
    public Courses getCourses(@PathVariable int courseId) {

        Courses theCourse= courseService.findById(courseId);

        if (theCourse == null) {
            throw new RuntimeException("Course id not found - " + courseId);
        }

        return theCourse;
    }

    // add mapping for POST /course - add new course

    @PostMapping("/courses")
    public Courses addCourse(@RequestBody Courses theCourse) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theCourse.setId(0);

        Courses dbCourses = courseService.save(theCourse);

        return dbCourses;
    }

    // add mapping for PUT /courses - update existing course

    @PutMapping("/courses")
    public Courses updateCourses(@RequestBody Courses theCourse) {

        Courses dbCourses = courseService.save(theCourse);

        return dbCourses;
    }

    // add mapping for DELETE /courses/{courseId} - delete course

    @DeleteMapping("/courses/{courseId}")
    public String deleteCourses(@PathVariable int courseId) {

        Courses tempCour = courseService.findById(courseId);

        // throw exception if null

        if (tempCour == null) {
            throw new RuntimeException("Course id not found - " + courseId);
        }

        courseService.deleteById(courseId);

        return "Deleted course id - " + courseId;
    }

    // Add an exception handler using @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<CourseErrorResponse> handleException(CourseNotFoundException exc) {

        // create a StudentErrorResponse

        CourseErrorResponse error = new CourseErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler ... to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<CourseErrorResponse> handleException(Exception exc) {

        // create a StudentErrorResponse
        CourseErrorResponse error = new CourseErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
