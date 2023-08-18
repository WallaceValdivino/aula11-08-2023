package com.example.productbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productbackend.entities.Product;
import com.example.productbackend.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

   @Autowired
   private ProductRepository repository;

   public List<Product> getProducts() {
      return this.repository.findAll();
   }

   public Product getProduct(long id) {
      return this.repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found"));
   }

   public Product deleteProductbyId(long id){
      return null;
//return this.repository.deleteById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
}
   }

