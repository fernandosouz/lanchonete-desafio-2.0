package com.example.startup.demo.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LancheNotFoundException extends RuntimeException {

    public LancheNotFoundException(long id, Class<?> typeClass) {
        super("Lanche com código: " + id + " não existe. Tente novamente");
    }
}


