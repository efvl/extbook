package com.evv.extbook.service;

import com.evv.extbook.dto.BookResponse;
import com.evv.extbook.dto.CreateBookRequest;
import com.evv.extbook.entity.Book;
import com.evv.extbook.entity.Language;
import com.evv.extbook.mapper.BookMapper;
import com.evv.extbook.repository.BookRepository;
import com.evv.extbook.repository.LanguageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final LanguageRepository languageRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository repository, LanguageRepository languageRepository, BookMapper mapper) {
        this.bookRepository = repository;
        this.languageRepository = languageRepository;
        this.bookMapper = mapper;
    }

    @Override
    public BookResponse create(CreateBookRequest request) {
        // Ensure FK exists (important!)
        Language language = languageRepository.findById(request.languageId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Language not found: " + request.languageId())
                );
        Book book = bookMapper.toEntity(request);
        book.setLanguage(language);
        Book saved = bookRepository.save(book);
        return bookMapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponse findById(UUID id) {
        return bookRepository.findById(id)
                .map(bookMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException(String.format("book not found (id=%s)", id)));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookResponse> selectAll(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map(bookMapper::toResponse);
    }

    @Override
    public BookResponse update(UUID id, CreateBookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));
        bookMapper.updateEntity(request, book);
        if (!book.getLanguage().getId().equals(request.languageId())) {
            Language language = languageRepository.findById(request.languageId())
                    .orElseThrow(() -> new EntityNotFoundException("Language not found"));
            book.setLanguage(language);
        }
        return bookMapper.toResponse(book);
    }

    @Override
    public void delete(UUID id) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Book not found");
        }
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookResponse> findByLanguageId(UUID languageId, Pageable pageable) {
        return bookRepository.findByLanguage_Id(languageId, pageable)
                .map(bookMapper::toResponse);
    }

}
