package com.evv.extbook.service;

import com.evv.extbook.dto.LanguageDto;
import com.evv.extbook.mapper.LanguageMapper;
import com.evv.extbook.repository.LanguageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    public LanguageServiceImpl(LanguageMapper mapper, LanguageRepository languageRepository) {
        this.languageMapper = mapper;
        this.languageRepository = languageRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public LanguageDto findById(UUID id) {
        return languageRepository.findById(id)
                .map(languageMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(String.format("language not found (id=%s)", id)));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<LanguageDto> selectAll(Pageable pageable) {
        return languageRepository.findAll(pageable)
                .map(languageMapper::toDto);
    }

}
