package com.guerra.poke.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String codeError){
        super(codeError);
    }
}
