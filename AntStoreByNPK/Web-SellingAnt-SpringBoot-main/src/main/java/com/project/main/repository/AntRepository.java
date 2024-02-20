package com.project.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.main.entity.Ant;

public interface AntRepository extends JpaRepository<Ant, Integer> {
    // You can define custom query methods here if needed
}