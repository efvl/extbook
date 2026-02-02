package com.evv.extbook.dto;

import java.util.UUID;

public record BookResponse(
        UUID id,
        String title,
        String authors,
        Integer year,
        String info,
        String isbn,
        LanguageDto language
) {}
