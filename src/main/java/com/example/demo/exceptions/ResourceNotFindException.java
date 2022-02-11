package com.example.demo.exceptions;

public class ResourceNotFindException extends RuntimeException{
    private static final long serialVersionUD = 1L;

    public ResourceNotFindException(Object id) {
        super("Resource not found. Id " + id);
    }
}
