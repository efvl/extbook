package com.evv.extbook.controller;

import com.evv.extbook.dto.LanguageDto;
import com.evv.extbook.service.LanguageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    public ResponseEntity<List<LanguageDto>> searchLanguages() {
        return ResponseEntity.ok().body(languageService.selectAll());
    }

}
