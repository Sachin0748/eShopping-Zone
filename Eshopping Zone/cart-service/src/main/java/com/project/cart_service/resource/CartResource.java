package com.capgemini.cart_service.resource;

import com.capgemini.cart_service.entity.Cart;
import com.capgemini.cart_service.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartResource {

    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable int id) {
        return ResponseEntity.ok(cartService.getCartById(id));
    }

    @PutMapping
    public ResponseEntity<Cart> updateCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(cartService.updateCart(cart));
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        return ResponseEntity.ok(cartService.getAllCarts());
    }

    @GetMapping("/total/{id}")
    public double cartTotal(@PathVariable int id) {
        return cartService.cartTotal(id);
    }

    @PostMapping
    public void addCart(@RequestBody Cart cart) {
        cartService.addCart(cart);
    }
}
