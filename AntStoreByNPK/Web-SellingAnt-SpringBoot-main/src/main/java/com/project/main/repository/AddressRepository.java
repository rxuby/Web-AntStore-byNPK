package com.project.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.main.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    // You can define custom query methods here if needed
}
