package com.project.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.main.entity.Cart;
import com.project.main.entity.CartItem;
import com.project.main.repository.CartItemRepository;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public List<CartItem> findByCart(Cart cart) {
        return cartItemRepository.findByCart(cart);
    }

    @Override
    public void saveCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }
    // Implement other methods as needed

    @Override
    public void deleteCartItem(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
        cartItemRepository.flush();
    }

    @Override
    public CartItem getCartItemById(int cartItemId) {
        return cartItemRepository.findById(cartItemId);
    }
}
