package com.project.main.service;

import java.util.List;

import com.project.main.entity.Cart;
import com.project.main.entity.Customer;

public interface CartService {
    void saveCart(Cart cart);
    Cart getCartById(int cartId);
    void deleteCart(Cart cart);
    void updateCart(Cart cart);
    List<Cart> getAllCarts();   
    List<Cart> findByCustomer(Customer customer);
}
