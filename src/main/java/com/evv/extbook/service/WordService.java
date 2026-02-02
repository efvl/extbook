package com.evv.extbook.service;

import com.evv.extbook.dto.CreateWordRequest;
import com.evv.extbook.dto.WordResponse;

import java.util.List;
import java.util.UUID;

public interface WordService {

    WordResponse create(CreateWordRequest request);

    WordResponse findById(UUID id);

    List<WordResponse> selectAll();

}
