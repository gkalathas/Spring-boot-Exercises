package com.example.relationSpringboot.service;

import com.example.relationSpringboot.model.Cart;
import com.example.relationSpringboot.model.Item;
import com.example.relationSpringboot.model.excepction.CartNotFoundException;
import com.example.relationSpringboot.model.excepction.ItemIsAlreadyAssignedException;
import com.example.relationSpringboot.model.excepction.ItemNotFoundException;
import com.example.relationSpringboot.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class CartService {

    private final CartRepository cartRepository;

    private final ItemService itemService;

    @Autowired
    public CartService(CartRepository cartRepository, ItemService itemService) {
        this.cartRepository = cartRepository;
        this.itemService = itemService;
    }

    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }
    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow(() ->
                new CartNotFoundException(id));
    }
    public Cart deleteCart(Long id){
        Cart cart = getCart(id);
        cartRepository.delete(cart);
        return cart;
    }

    @Transactional
    public Cart editCart(Long id, Cart cart){
        Cart cartToEdit = getCart(id);
        cartToEdit.setName(cart.getName());
        return cartToEdit;
    }
    @Transactional
    public Cart addItemToCart(Long cartId, Long itemId){
        Cart cart = getCart(cartId);
        Item item =  itemService.getItem(itemId);
        //!cart.getItems().contains(item) anti gia to apo katw if
        if(Objects.nonNull(item.getCart())) {
            throw new ItemIsAlreadyAssignedException(itemId, item.getCart().getId());
        }
        cart.addItem(item);
        item.setCart(cart);
        return cart;
    }

    @Transactional
    public Cart removeItemFromCart(Long cartId, Long itemId){
        Cart cart =  getCart(cartId);
        Item item = itemService.getItem(itemId);
        cart.removeItem(item);
        return cart;
    }
}
