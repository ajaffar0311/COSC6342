package com.isms.isms.controller.ProfessorController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ProfessorRestExceptionHandler {


    // add exception handling code here

    @ExceptionHandler
    public ResponseEntity<ProfessorErrorResponse> handleException(ProfessorNotFoundException exc) {

        // create a ProfessorErrorResponse

        ProfessorErrorResponse error = new ProfessorErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler ... to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<ProfessorErrorResponse> handleException(Exception exc) {

        // create a ProfessorErrorResponse
        ProfessorErrorResponse error = new ProfessorErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
