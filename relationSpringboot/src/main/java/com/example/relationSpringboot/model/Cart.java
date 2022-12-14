package com.example.relationSpringboot.model;


import com.example.relationSpringboot.model.dto.CartDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private List<Item> items = new ArrayList<>();


    public void addItem(Item item){
        items.add(item);
    }
    public void removeItem(Item item){
        items.remove(item);
    }

    public static Cart from(CartDto cartDto){
        Cart cart = new Cart();
        cart.setName(cartDto.getName());
        return cart;
    }

}
