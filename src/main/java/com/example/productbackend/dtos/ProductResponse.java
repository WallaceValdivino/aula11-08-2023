package com.example.productbackend.dtos;

public record ProductResponse(
    long id,
    String name,
    double price

) {
}
