package com.evv.extbook.dto;

import jakarta.persistence.Column;

import java.util.UUID;

public record WordDto(
        UUID id,
        UUID bookId,
        int pageNum,
        int lineNum,
        int wordNum,
        String txtContent,
        UUID cardId,
        String status
) {}
