package com.isms.isms.controller.ProfessorController;

import com.isms.isms.entity.Professor;
import com.isms.isms.service.ProfessorService.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfessorController {

    private ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    // expose "/professors" and return a list of professors
    @GetMapping("/professors")
    public List<Professor> findAll() {
        return professorService.findAll();
    }

    // add mapping for GET /professors/{professorId}
    @GetMapping("/professors/{professorId}")
    public Professor getProfessor(@PathVariable int professorId) {

        Professor theProfessor = professorService.findById(professorId);

        if (theProfessor == null) {
            throw new RuntimeException("Professor id not found - " + professorId);
        }

        return theProfessor;
    }

    // add mapping for POST /professors - add new Professor

    @PostMapping("/professors")
    public Professor addProfessor(@RequestBody Professor theProfessor) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theProfessor.setId(0);

        Professor dbProfessor = professorService.save(theProfessor);

        return dbProfessor;
    }

    // add mapping for PUT /professors - update existing student

    @PutMapping("/professors")
    public Professor updateProfessor(@RequestBody Professor theProfessor) {

        Professor dbProfessor = professorService.save(theProfessor);

        return dbProfessor;
    }

    // add mapping for DELETE /professors/{professorId} - delete professor

    @DeleteMapping("/professors/{professorId}")
    public String deleteProfessor(@PathVariable int professorId) {

        Professor tempProf = professorService.findById(professorId);

        // throw exception if null

        if (tempProf == null) {
            throw new RuntimeException("Student id not found - " + professorId);
        }

        professorService.deleteById(professorId);

        return "Deleted professor id - " + professorId;
    }

}
