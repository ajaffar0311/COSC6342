package com.isms.isms.service.ProfessorService;

import com.isms.isms.entity.Professor;
import com.isms.isms.entity.Student;

import java.util.List;

public interface ProfessorService {

    List<Professor> findAll();

    Professor findById(int theId);

    Professor save(Professor theProfessor);

    void deleteById(int theId);
}
