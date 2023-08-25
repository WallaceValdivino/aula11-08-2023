package com.example.productbackend.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.productbackend.dtos.ProductRequest;
import com.example.productbackend.dtos.ProductResponse;
import com.example.productbackend.entities.Product;
import com.example.productbackend.services.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        var products = this.service.getProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        var product = this.service.getProduct(id);
       return ResponseEntity.ok(product);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
     this.service.deleteProductById(id);
       return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ProductResponse> save(@RequestBody ProductRequest product){
        var savedProduct = this.service.save(product);
        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedProduct.id())

                .toUri();
        return ResponseEntity.created(location).body(savedProduct);
    }

    @PutMapping("{id}")
   public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Product product){
    this.service.update(id,product);
        return ResponseEntity.ok().build();

    }
}
