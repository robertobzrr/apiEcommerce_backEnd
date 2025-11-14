package com.robertoapi.login_and_authentication_api.service;

import com.robertoapi.login_and_authentication_api.model.Cart;
import com.robertoapi.login_and_authentication_api.repository.CartRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    public final CartRepository cartRepository;

    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

//------------------------------------------------------------------------------------------

    public void createCart(Cart cart){
        cartRepository.save(cart);
    }


    public List<Cart> findAllCarts(){
        return cartRepository.findAll();
    }


    public Optional<Cart> findCartById(Long id){
        return cartRepository.findById(id);
    }


    public void deleteCartById(Long id){
        cartRepository.deleteById(id);
    }


    public void updateCartById(Long id, Cart updateCart){
        Optional<Cart> cartDB = findCartById(id);

        if(cartDB.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found");
        }
        else{
            Cart editCart = cartDB.get();

            editCart.setNameCart(updateCart.getNameCart());
            editCart.setProduct(updateCart.getProduct());

            cartRepository.save(editCart);
        }
    }



}
