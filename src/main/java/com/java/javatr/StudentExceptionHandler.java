package com.java.javatr;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler({StudentNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

    public ResponseEntity<StudentError> getname( StudentNotFoundException ex, WebRequest webRequest )  {
        return new ResponseEntity( new StudentError( ex.message, new Date(), ex.studentname ), HttpStatus.INTERNAL_SERVER_ERROR );
    }


}
