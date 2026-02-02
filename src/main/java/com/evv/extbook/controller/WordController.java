package com.evv.extbook.controller;

import com.evv.extbook.dto.CreateWordRequest;
import com.evv.extbook.dto.WordResponse;
import com.evv.extbook.service.WordService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/word")
@CrossOrigin
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @PostMapping
    public ResponseEntity<WordResponse> create(@Valid @RequestBody CreateWordRequest request) {
        WordResponse created = wordService.create(request);
        URI location = URI.create("/v1/word/" + created.id());
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WordResponse> getWord(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(wordService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<WordResponse>> getAllWords() {
        return ResponseEntity.ok(wordService.selectAll());
    }

}
