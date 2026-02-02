package com.evv.extbook.repository;

import com.evv.extbook.entity.Book;

import java.util.UUID;

public interface BookRepository extends BaseJpaRepository<Book, UUID> {

}
