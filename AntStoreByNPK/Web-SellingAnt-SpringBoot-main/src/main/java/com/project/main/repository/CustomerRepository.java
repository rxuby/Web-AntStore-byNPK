package com.project.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.main.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Customer findByUsername(String username);
    // You can define custom query methods here if needed\
}
