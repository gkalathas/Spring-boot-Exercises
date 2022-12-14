package com.example.relationSpringboot.model.dto;

import com.example.relationSpringboot.model.Cart;
import lombok.Data;

@Data
public class PlainCartDto {

    private Long id;
    private String name;

    public static PlainCartDto from(Cart cart) {
        PlainCartDto plainCartDto = new PlainCartDto();
        plainCartDto.setId(cart.getId());
        plainCartDto.setName(cart.getName());
        return plainCartDto;
    }

}
