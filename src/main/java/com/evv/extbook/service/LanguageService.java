package com.evv.extbook.service;

import com.evv.extbook.dto.LanguageDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface LanguageService {

    LanguageDto findById(UUID id);

    Page<LanguageDto> selectAll(Pageable pageable);

}
