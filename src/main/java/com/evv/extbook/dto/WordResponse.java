package com.evv.extbook.dto;

import com.evv.extbook.entity.WordStatus;

import java.util.UUID;

public record WordResponse(
        UUID id,
        Long pageNum,
        Long lineNum,
        Long wordNum,
        String txtContent,
        WordStatus status,
        UUID bookId
) {}
