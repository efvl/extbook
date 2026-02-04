package com.evv.extbook.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateLanguageRequest(
    @NotNull UUID id,
    @Size(max = 255) String shortName,
    @Size(max = 255) String fullName
) {}
