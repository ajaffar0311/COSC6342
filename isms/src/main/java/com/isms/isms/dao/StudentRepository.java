package com.isms.isms.dao;

import com.isms.isms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Integer> {

    // that's it... no need to write any code

}
