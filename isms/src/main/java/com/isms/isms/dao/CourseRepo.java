package com.isms.isms.dao;


import com.isms.isms.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Courses, Integer> {
}
