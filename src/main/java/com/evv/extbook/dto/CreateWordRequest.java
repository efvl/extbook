package com.evv.extbook.dto;

import com.evv.extbook.entity.WordStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateWordRequest(
        @NotNull UUID bookId,
        Long pageNum,
        Long lineNum,
        Long wordNum,
        @Size(max = 128) String txtContent,
        WordStatus status
) {}
