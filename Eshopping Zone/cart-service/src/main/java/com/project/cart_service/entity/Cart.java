package com.capgemini.cart_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    private int userId;
    private double totalPrice;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;
}
