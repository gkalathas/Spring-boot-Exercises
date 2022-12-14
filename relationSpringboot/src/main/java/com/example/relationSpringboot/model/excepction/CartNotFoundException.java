package com.example.relationSpringboot.model.excepction;

import java.text.MessageFormat;

public class CartNotFoundException extends RuntimeException {

    public CartNotFoundException(Long id){
        super(MessageFormat.format("could not find cart with id: {}", id));
    }
}
