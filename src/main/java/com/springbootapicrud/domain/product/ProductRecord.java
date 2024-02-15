package com.springbootapicrud.domain.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public record ProductRecord(
  @NotBlank
  String name,
  @NotNull
  double price,
  @NotBlank
  String description
) { }
