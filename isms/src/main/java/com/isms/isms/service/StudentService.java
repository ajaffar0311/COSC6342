package com.isms.isms.service;

import com.isms.isms.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(int theId);

    Student save(Student theStudent);

    void deleteById(int theId);
}
