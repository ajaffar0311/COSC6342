package com.isms.isms.service.CourseService;

import com.isms.isms.entity.Courses;
import com.isms.isms.entity.Professor;

import java.util.List;

public interface CourseService {

    List<Courses> findAll();

    Courses findById(int theId);

    Courses save(Courses courses);

    void deleteById(int theId);
}
