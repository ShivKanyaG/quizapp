package com.shiv.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
public class QuizAppExceptionController {

    @ExceptionHandler(value =NumberFormatException.class)
    public ResponseEntity<ExceptionResponse> handelNumberFormatException(){
        ExceptionResponse object = new ExceptionResponse();
        object.setErrorMessage("Exception occured due to number format exception");
        object.setErrorStatusCode("400");
        object.setExceptionName(NumberFormatException.class.getName());
        return new ResponseEntity<ExceptionResponse>(object, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value =NullPointerException.class)
    public ResponseEntity<ExceptionResponse> handelNullPointerExceptionException(){
        ExceptionResponse object = new ExceptionResponse();
        object.setErrorMessage("Exception occured due to null  exception");
        object.setErrorStatusCode("500");
        object.setExceptionName(NullPointerException.class.getName());
        return new ResponseEntity<ExceptionResponse>(object, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value =DataNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handelDataNotFoundException(DataNotFoundException dataNotFoundException){
        ExceptionResponse object = new ExceptionResponse();
        object.setErrorMessage(dataNotFoundException.getMessage());
        object.setErrorStatusCode(HttpStatus.NOT_FOUND.toString());
        object.setExceptionName(DataNotFoundException.class.getName());
        return new ResponseEntity<ExceptionResponse>(object, HttpStatus.NOT_FOUND);
    }
}
