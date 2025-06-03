package com.capgemini.cart_service.repository;

import com.capgemini.cart_service.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findByCartId(int cartId);
}

