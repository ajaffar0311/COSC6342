package com.isms.isms.service.CourseService;


import com.isms.isms.dao.CourseRepo;
import com.isms.isms.dao.ProfessorRepositoy;
import com.isms.isms.entity.Courses;
import com.isms.isms.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepo courseRepo;

    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo ) {
        this.courseRepo = courseRepo;
    }

    @Override
    public List<Courses> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public Courses findById(int theId) {
        Optional<Courses> result = courseRepo.findById(theId);

        Courses theCourse = null;

        if (result.isPresent()) {
            theCourse = result.get();
        }
        else {
            // we didn't find the course
            throw new RuntimeException("Did not find course id - " + theId);
        }

        return theCourse;
    }

    @Override
    public Courses save(Courses theCourse) {
        return courseRepo.save(theCourse);
    }

    @Override
    public void deleteById(int theId) {


    }
}
