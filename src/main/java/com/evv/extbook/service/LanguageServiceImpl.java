package com.evv.extbook.service;

import com.evv.extbook.dto.LanguageDto;
import com.evv.extbook.mapper.LanguageMapper;
import com.evv.extbook.repository.LanguageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    public LanguageServiceImpl(LanguageMapper mapper, LanguageRepository languageRepository) {
        this.languageMapper = mapper;
        this.languageRepository = languageRepository;
    }

    @Override
    public LanguageDto findById(UUID id) {
        return languageRepository.findById(id)
                .map(languageMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(String.format("language not found (id=%s)", id)));
    }

    @Override
    public List<LanguageDto> selectAll() {
        return languageRepository.findAll().stream()
                .map(languageMapper::toDto)
                .toList();
    }

}
