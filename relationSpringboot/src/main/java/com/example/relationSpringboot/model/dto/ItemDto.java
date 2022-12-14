package com.example.relationSpringboot.model.dto;


import com.example.relationSpringboot.model.Item;
import lombok.Data;

import java.util.Objects;

// exactly the same as the item entity
@Data
public class ItemDto {
    private Long id;
    private String serializeNumber;
    private PlainCartDto plainCartDto;



    public static ItemDto from(Item item){

        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setSerializeNumber(item.getSerialNumber());

        if(Objects.nonNull(item.getCart())) {
            itemDto.setPlainCartDto(PlainCartDto.from(item.getCart()));
        }
        return itemDto;
    }


}
