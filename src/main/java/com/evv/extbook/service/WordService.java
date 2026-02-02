package com.evv.extbook.service;

import com.evv.extbook.dto.CreateWordRequest;
import com.evv.extbook.dto.WordResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface WordService {

    WordResponse create(CreateWordRequest request);

    WordResponse findById(UUID id);

    Page<WordResponse> selectAll(Pageable pageable);

    WordResponse update(UUID id, CreateWordRequest request);

    void delete(UUID id);

    Page<WordResponse> findByBookId(UUID bookId, Pageable pageable);

}
