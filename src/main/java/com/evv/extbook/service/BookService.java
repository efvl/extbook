package com.evv.extbook.service;

import com.evv.extbook.dto.BookResponse;
import com.evv.extbook.dto.CreateBookRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface BookService {

    BookResponse create(CreateBookRequest request);

    BookResponse findById(UUID id);

    Page<BookResponse> selectAll(Pageable pageable);

    BookResponse update(UUID id, CreateBookRequest request);

    void delete(UUID id);

    Page<BookResponse> findByLanguageId(UUID languageId, Pageable pageable);

}
