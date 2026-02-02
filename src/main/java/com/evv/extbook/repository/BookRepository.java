package com.evv.extbook.repository;

import com.evv.extbook.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface BookRepository extends BaseJpaRepository<Book, UUID> {

    Page<Book> findByLanguage_Id(UUID languageId, Pageable pageable);

}
