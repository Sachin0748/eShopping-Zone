package com.capgemini.cart_service.service;

import com.capgemini.cart_service.entity.Cart;

public interface CartService {
    Cart getCartById(int id);
    Cart updateCart(Cart cart);
    double cartTotal(int id);
    Cart addCart(Cart cart);
}
