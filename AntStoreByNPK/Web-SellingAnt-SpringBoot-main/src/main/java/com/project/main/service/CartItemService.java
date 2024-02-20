package com.project.main.service;

import java.util.List;

import com.project.main.entity.Cart;
import com.project.main.entity.CartItem;

public interface CartItemService {
    List<CartItem> getAllCartItems();
    List<CartItem> findByCart(Cart cart);
    // Add other methods as needed
    void saveCartItem(CartItem cartItem);
    CartItem getCartItemById(int cartItemId);
    void deleteCartItem(CartItem cartItem);
}