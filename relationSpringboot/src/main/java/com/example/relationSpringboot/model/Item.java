package com.example.relationSpringboot.model;


import com.example.relationSpringboot.model.dto.ItemDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "serial_number")
    private String serialNumber;

    @ManyToOne
    private Cart cart;


    public static Item from(ItemDto itemDto) {
        Item item = new Item();
        //use only in the case of editing so the id cannot be changed
        item.setSerialNumber(itemDto.getSerializeNumber());
        return item;
    }

}
