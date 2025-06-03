package com.capgemini.cart_service.service;

import com.capgemini.cart_service.entity.Cart;
import com.capgemini.cart_service.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart getCartById(int id) {
        return cartRepository.findByCartId(id);
    }

    @Override
    public Cart addCart(Cart cart) {
        double total = cart.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
        cart.setTotalPrice(total);
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(Cart cart) {
        double total = cart.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
        cart.setTotalPrice(total);
        return cartRepository.save(cart);
    }

    @Override
    public double cartTotal(int id) {
        Cart cart = cartRepository.findByCartId(id);
        return cart.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }


}
