package com.evv.extbook.controller;

import com.evv.extbook.dto.LanguageDto;
import com.evv.extbook.service.LanguageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/lang")
@CrossOrigin
public class LanguageController {

    private final LanguageService languageService;


    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageDto> getLanguage(@PathVariable UUID id) {
        return ResponseEntity.ok(languageService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<LanguageDto>> searchLanguages(Pageable pageable) {
        return ResponseEntity.ok(
                languageService.selectAll(pageable)
        );
    }

}
