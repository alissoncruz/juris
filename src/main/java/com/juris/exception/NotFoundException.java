package com.juris.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.PRECONDITION_FAILED;

@ResponseStatus(NOT_FOUND)
public class NotFoundException extends RuntimeException{

//    public NotFoundException(){
//        super(String.valueOf(HttpStatus.NOT_FOUND));
//    }

    public NotFoundException(String exception){
        super(exception);
    }
}
