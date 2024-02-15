package com.springbootapicrud.controllers;

import com.springbootapicrud.domain.product.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/product")
public class ProductController {
  @Autowired
  private ProductRepository _repository;
  @GetMapping
  public ResponseEntity getAllProducts() {
    var products = _repository.findAll();
    return ResponseEntity.ok(products);
  }

  @PostMapping
  public ResponseEntity createProduct(@RequestBody @Valid ProductRecord data) {
    var product = _repository.save(new Product(data));
    return ResponseEntity.ok(product);
  }

  @PutMapping
  @Transactional
  public ResponseEntity updateProduct(@RequestBody @Valid ProductUpdateRecord data) {
    Product product = _repository.findById(data.id()).get();
    product.setName(data.name());
    product.setPrice(data.price());
    product.setDescription(data.description());
    return ResponseEntity.ok(_repository.save(product));
  }

  @DeleteMapping
  public ResponseEntity deleteProduct(@RequestBody @Valid ProductDeleleRecord data) {
    Product product = _repository.findById(data.id()).get();
    _repository.delete(product);
    return ResponseEntity.ok(product);
  }
}