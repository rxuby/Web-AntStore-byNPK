package com.project.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.main.entity.Cart;
import com.project.main.entity.Customer;
import com.project.main.repository.CartRepository;


@Service
public class CartServiceImpl implements CartService{
    CartRepository cartRepository;
    
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    @Override
    public void saveCart(Cart cart) {
        cartRepository.save(cart);
        
    }
    
    @Override
    public Cart getCartById(int cartId) {
        return cartRepository.findById(cartId);
    }


    @Override
    public void deleteCart(Cart cart) {
        cartRepository.delete(cart);
    }

    @Override
    public void updateCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public List<Cart> findByCustomer(Customer customer) {
        return cartRepository.findByCustomer(customer);
    }
}
