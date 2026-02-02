package com.evv.extbook.dto;

import java.util.UUID;

public record BookDto(
        UUID id,
        UUID languageId,
        String title,
        String authors,
        Integer year,
        String info,
        String isbn
) {}
