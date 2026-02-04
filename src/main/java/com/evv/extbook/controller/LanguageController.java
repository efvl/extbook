package com.evv.extbook.controller;

import com.evv.extbook.dto.BookResponse;
import com.evv.extbook.dto.CreateBookRequest;
import com.evv.extbook.dto.CreateLanguageRequest;
import com.evv.extbook.dto.LanguageDto;
import com.evv.extbook.dto.LanguageResponse;
import com.evv.extbook.service.LanguageService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/lang")
@CrossOrigin
public class LanguageController {

    private final LanguageService languageService;


    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping
    public ResponseEntity<LanguageResponse> create(@Valid @RequestBody CreateLanguageRequest request) {
        LanguageResponse created = languageService.create(request);
        URI location = URI.create("/v1/lang/" + created.id());
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanguageResponse> update(
            @PathVariable UUID id,
            @Valid @RequestBody CreateLanguageRequest request
    ) {
        return ResponseEntity.ok(languageService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        languageService.delete(id);
        return ResponseEntity.noContent().build();
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
