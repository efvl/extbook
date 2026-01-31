package com.evv.extbook.dto;

import java.util.UUID;

public record LanguageDto(
        UUID id,
        String shortName,
        String fullName
) {}
