package com.isms.isms.controller.ProfessorController;

public class ProfessorNotFoundException extends RuntimeException{

    public ProfessorNotFoundException(String message) {
        super(message);
    }

    public ProfessorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProfessorNotFoundException(Throwable cause) {
        super(cause);
    }
}
