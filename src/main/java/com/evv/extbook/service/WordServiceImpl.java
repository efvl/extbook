package com.evv.extbook.service;

import com.evv.extbook.dto.CreateWordRequest;
import com.evv.extbook.dto.WordResponse;
import com.evv.extbook.entity.Book;
import com.evv.extbook.entity.Word;
import com.evv.extbook.mapper.WordMapper;
import com.evv.extbook.repository.BookRepository;
import com.evv.extbook.repository.WordRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;
    private final BookRepository bookRepository;
    private final WordMapper wordMapper;

    public WordServiceImpl(WordRepository wordRepository, BookRepository bookRepository, WordMapper wordMapper) {
        this.wordRepository = wordRepository;
        this.bookRepository = bookRepository;
        this.wordMapper = wordMapper;
    }

    @Override
    public WordResponse create(CreateWordRequest request) {
        // 1️⃣ Verify that the book exists
        Book book = bookRepository.findById(request.bookId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Book not found: " + request.bookId()
                ));
        // 2️⃣ Map request → entity
        Word word = wordMapper.toEntity(request);
        // 3️⃣ Set the actual book entity
        word.setBook(book);
        // 4️⃣ Save entity
        Word saved = wordRepository.save(word);
        // 5️⃣ Map entity → response DTO
        return wordMapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public WordResponse findById(UUID id) {
        Word word = wordRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Word not found: " + id));
        return wordMapper.toResponse(word);
    }

    @Override
    @Transactional(readOnly = true)
    public List<WordResponse> selectAll() {
        return wordRepository.findAll()
                .stream()
                .map(wordMapper::toResponse)
                .toList();
    }
}