package com.isms.isms.dao;

import com.isms.isms.entity.Professor;
import com.isms.isms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepositoy extends JpaRepository<Professor, Integer> {
}
