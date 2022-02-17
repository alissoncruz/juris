package com.juris.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.PRECONDITION_FAILED;

@ResponseStatus(PRECONDITION_FAILED)
public class BusinessException extends RuntimeException{

//    //public BusinessException(){
//        super(String.valueOf(PRECONDITION_FAILED));
//    }

    public BusinessException(String exception){
        super(exception);
    }
}
