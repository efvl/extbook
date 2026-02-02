package com.evv.extbook.controller;

import com.evv.extbook.dto.CreateWordRequest;
import com.evv.extbook.dto.WordResponse;
import com.evv.extbook.service.WordService;
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
    public ResponseEntity<Page<WordResponse>> getAllWords(Pageable pageable) {
        return ResponseEntity.ok(
                wordService.selectAll(pageable)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<WordResponse> update(@PathVariable UUID id, @Valid @RequestBody CreateWordRequest request) {
        return ResponseEntity.ok(
                wordService.update(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        wordService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-book/{bookId}")
    public ResponseEntity<Page<WordResponse>> findByBookId(@PathVariable UUID bookId, Pageable pageable) {
        return ResponseEntity.ok(
                wordService.findByBookId(bookId, pageable)
        );
    }

}
