package com.project.main.service;

import java.util.List;

import com.project.main.entity.Cart;
import com.project.main.entity.Transaction;

public interface TransactionService {
    void saveTransaction(Transaction transaction);
    void deleteTransaction(Transaction transaction);
    void updateTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    Transaction getByCart(Cart cart);
    
}
