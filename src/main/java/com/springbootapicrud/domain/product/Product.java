package com.springbootapicrud.domain.product;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
@Table(name = "product")
@EqualsAndHashCode(of = "id")
public class Product {
  public Product(ProductRecord data) {
    this.name = data.name();
    this.price = data.price();
    this.description = data.description();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String name;
  private double price;
  private String description;
}