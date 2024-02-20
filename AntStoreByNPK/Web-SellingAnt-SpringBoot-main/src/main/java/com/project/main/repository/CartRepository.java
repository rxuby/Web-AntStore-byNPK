package com.project.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.main.entity.Cart;
import com.project.main.entity.Customer;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    // You can define custom query methods here if needed
    Cart findById(int cartId);
    List<Cart> findByCustomer(Customer customer);
}