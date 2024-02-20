package com.project.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.main.entity.Transaction;
import com.project.main.entity.Cart;


public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    // You can define custom query methods here if needed
    Transaction getByCart(Cart cart);
}