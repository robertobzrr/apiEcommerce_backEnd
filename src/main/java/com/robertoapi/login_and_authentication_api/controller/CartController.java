package com.robertoapi.login_and_authentication_api.controller;
import com.robertoapi.login_and_authentication_api.model.Cart;
import com.robertoapi.login_and_authentication_api.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

//------------------------------------------------------------------------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCart(@RequestBody Cart cart){
        cartService.createCart(cart);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cart> findAllCarts(){
        return cartService.findAllCarts();
    }


    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Cart> findCartById(@PathVariable Long id){
        return cartService.findCartById(id);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCartById(@PathVariable Long id){
        cartService.deleteCartById(id);
    }


    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCartById(@PathVariable Long id, @RequestBody Cart updateCart){
        cartService.updateCartById(id, updateCart);
    }




}
