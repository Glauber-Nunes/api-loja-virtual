package com.dev.LojaVirtual.exceptions;

public class EntityNotFound extends RuntimeException{

    public EntityNotFound(String message) {
        super(message);
    }
}