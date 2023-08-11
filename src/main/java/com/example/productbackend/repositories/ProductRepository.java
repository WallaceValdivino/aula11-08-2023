package com.example.productbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productbackend.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
