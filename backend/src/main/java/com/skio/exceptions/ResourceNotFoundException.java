package com.skio.exceptions;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String errMsg){
        super(errMsg);
    }
}
