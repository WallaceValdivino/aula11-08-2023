package com.example.productbackend.services;

import java.util.List;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productbackend.entities.Product;
import com.example.productbackend.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

     public List<Product> getProducts(){
        return this.repository.findAll();
     }

     public Product getProduct(long id){
        return this.repository.findById(id)
        .orElseThrow( ()-> new EntityNotFoundException("Product not found" )
        );
     }
}
