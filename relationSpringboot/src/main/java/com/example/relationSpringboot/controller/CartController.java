package com.example.relationSpringboot.controller;


import com.example.relationSpringboot.model.Cart;
import com.example.relationSpringboot.model.dto.CartDto;
import com.example.relationSpringboot.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carts")
public class CartController {

    CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    //create cart
    @PostMapping
    public ResponseEntity<CartDto> addCarts(@RequestBody final CartDto cartDto) {
        Cart cart = cartService.addCart(Cart.from(cartDto));
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.CREATED);
    }

    //Get all carts
    @GetMapping
    public ResponseEntity<List<CartDto>> getAllCarts() {
        List<Cart> carts = cartService.getCarts();
        List<CartDto> cartsDto = carts.stream().map(CartDto::from)
                .collect(Collectors.toList());
        return new ResponseEntity<>(cartsDto, HttpStatus.OK);
    }

    //Get a single cart
    @GetMapping(value = "{id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable("id") final Long id) {
        Cart cart = cartService.getCart(id);
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

    //Delete a cart
    @DeleteMapping(value = "{id}")
    public ResponseEntity<CartDto> deleteCart(@PathVariable("id") final Long id) {
        Cart cart = cartService.deleteCart(id);
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

    //Edit an existing cart
    @PutMapping(value = "{id}")
    public ResponseEntity<CartDto> editCart(@PathVariable("id") final Long id,
                                            @RequestBody final CartDto cartDto) {
        Cart editedCart = cartService.editCart(id, Cart.from(cartDto));
        return new ResponseEntity<>(CartDto.from(editedCart), HttpStatus.OK);

    }

    //Add item in the cart
    @PostMapping(value = "{cartId}/items/{itemId}/add")
    public ResponseEntity<CartDto> addItemToCart(@PathVariable("cartId") final Long cartId,
                                                 @PathVariable("itemId") final Long itemId) {
        Cart cart = cartService.addItemToCart(cartId, itemId);
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

    //Remove item from the cart
    @DeleteMapping(value = "{cartId}/items/{itemId}/remove")
    public ResponseEntity<CartDto> removeItemFromCart(@PathVariable("cartId") final Long cartId,
                                                      @PathVariable("itemId") final Long itemId) {
        Cart cart = cartService.removeItemFromCart(cartId, itemId);
        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

}
