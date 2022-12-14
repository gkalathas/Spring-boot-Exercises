package com.example.relationSpringboot.model.excepction;

import java.text.MessageFormat;

public class ItemNotFoundException extends RuntimeException{


    public ItemNotFoundException(Long id){
        super(MessageFormat.format("could not find item with id: {}", id));
    }
}
