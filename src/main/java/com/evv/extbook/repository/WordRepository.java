package com.evv.extbook.repository;

import com.evv.extbook.entity.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface WordRepository extends BaseJpaRepository<Word, UUID> {

    Page<Word> findByBook_Id(UUID bookId, Pageable pageable);

}
