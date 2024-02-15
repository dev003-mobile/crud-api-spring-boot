package com.springbootapicrud.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductUpdateRecord(
        @NotNull
        String id,
        @NotBlank
        String name,
        @NotNull
        double price,
        @NotBlank
        String description
) {
}
