package com.evv.extbook.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateBookRequest(
        @NotNull UUID languageId,
        @Size(max = 256) String title,
        @Size(max = 256) String authors,
        Integer year,
        @Size(max = 256) String info,
        @Size(max = 20) String isbn
) {}
