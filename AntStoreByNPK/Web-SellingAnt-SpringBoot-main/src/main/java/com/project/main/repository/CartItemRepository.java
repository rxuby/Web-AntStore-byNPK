package com.project.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.main.entity.Cart;
import com.project.main.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByCart(Cart cart); // Custom query method
    CartItem findById(int cartItemId);
}
