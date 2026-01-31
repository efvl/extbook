package com.evv.extbook.service;

import com.evv.extbook.dto.LanguageDto;
import java.util.List;
import java.util.UUID;


public interface LanguageService {

    LanguageDto findById(UUID id);

    List<LanguageDto> selectAll();

}
