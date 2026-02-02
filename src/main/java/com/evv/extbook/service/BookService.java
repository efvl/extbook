package com.evv.extbook.service;

import com.evv.extbook.dto.BookResponse;
import com.evv.extbook.dto.CreateBookRequest;

import java.util.List;
import java.util.UUID;

public interface BookService {

    BookResponse create(CreateBookRequest request);

    BookResponse findById(UUID id);

    List<BookResponse> selectAll();

}
