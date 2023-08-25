package com.example.productbackend.mappers;

import com.example.productbackend.dtos.ProductRequest;
import com.example.productbackend.dtos.ProductResponse;
import com.example.productbackend.entities.Product;


public class ProductMapper {
    public static Product toEntity(ProductRequest request){
Product product = new Product();
product.setName(request.name());
product.setPrice(request.price());
return product;        
    }

    public static ProductResponse toDTO(Product product){
        return new ProductResponse(product.getId(),product.getName(),product.getPrice());
    }
}
