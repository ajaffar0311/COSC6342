package com.isms.isms.service.ProfessorService;


import com.isms.isms.dao.ProfessorRepositoy;
import com.isms.isms.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorRepositoy professorRepositoy;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepositoy professorRepositoy) {
        this.professorRepositoy = professorRepositoy;
    }

    @Override
    public List<Professor> findAll() {
        return professorRepositoy.findAll();
    }

    @Override
    public Professor findById(int theId) {
        Optional<Professor> result = professorRepositoy.findById(theId);

        Professor theProfessor = null;

        if (result.isPresent()) {
            theProfessor = result.get();
        }
        else {
            // we didn't find the professor
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theProfessor;
    }

    @Override
    public Professor save(Professor theProfessor) {
        return professorRepositoy.save(theProfessor);
    }

    @Override
    public void deleteById(int theId) {


    }
}
