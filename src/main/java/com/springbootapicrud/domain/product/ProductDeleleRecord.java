package com.springbootapicrud.domain.product;

import jakarta.validation.constraints.NotNull;

public record ProductDeleleRecord(
        @NotNull
        String id
) { }
