package com.evv.extbook.service;

import com.evv.extbook.dto.CreateWordRequest;
import com.evv.extbook.dto.WordResponse;
import com.evv.extbook.entity.Book;
import com.evv.extbook.entity.Word;
import com.evv.extbook.mapper.WordMapper;
import com.evv.extbook.repository.BookRepository;
import com.evv.extbook.repository.WordRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public WordResponse update(UUID id, CreateWordRequest request) {
        Word word = wordRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Word not found"));
        wordMapper.updateEntity(request, word);
        if (!word.getBook().getId().equals(request.bookId())) {
            Book book = bookRepository.findById(request.bookId())
                    .orElseThrow(() -> new EntityNotFoundException("Book not found"));
            word.setBook(book);
        }
        return wordMapper.toResponse(word);
    }

    @Override
    public void delete(UUID id) {
        if (!wordRepository.existsById(id)) {
            throw new EntityNotFoundException("Word not found");
        }
        wordRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<WordResponse> findByBookId(UUID bookId, Pageable pageable) {
        return wordRepository.findByBook_Id(bookId, pageable)
                .map(wordMapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<WordResponse> selectAll(Pageable pageable) {
        return wordRepository.findAll(pageable)
                .map(wordMapper::toResponse);
    }
}