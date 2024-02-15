package com.springbootapicrud.controllers;

import com.springbootapicrud.domain.product.Product;
import com.springbootapicrud.domain.product.ProductRecord;
import com.springbootapicrud.domain.product.ProductRepository;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/product")
public class ProductController {
  @Autowired
  private ProductRepository _repository;
  @GetMapping("/all")
  public ResponseEntity getAllProducts() {
    var allProducts = _repository.findAll();
    return ResponseEntity.ok(allProducts);
  }

  @PostMapping("/create")
  public ResponseEntity createProduct(@RequestBody @Valid ProductRecord data) {
    var createProduct = _repository.save(new Product(data));
    return ResponseEntity.ok("Ok...");
  }
}