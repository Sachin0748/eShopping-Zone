package com.capgemini.cart_service.controller;

import com.capgemini.cart_service.entity.Cart;
import com.capgemini.cart_service.service.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private CartServiceImpl cartServiceimpl;

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getUserCart(@PathVariable int cartId) {
        return ResponseEntity.ok(cartServiceimpl.getCartById(cartId));
    }

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(cartServiceimpl.addCart(cart));
    }

    @DeleteMapping("/remove/{cartId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long cartId) {
        cartServiceimpl.removeItem(cartId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getTotal/{userId}")
    public ResponseEntity<Double> cartTotal(@PathVariable int cartId) {
        return ResponseEntity.ok(cartServiceimpl.cartTotal(cartId));
    }
}
