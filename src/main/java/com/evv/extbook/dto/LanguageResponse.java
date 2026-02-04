package com.evv.extbook.dto;

import java.util.UUID;

public record LanguageResponse(
        UUID id,
        String shortName,
        String fullName
) {}
