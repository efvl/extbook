package com.evv.extbook.repository;

import com.evv.extbook.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LanguageRepository extends BaseJpaRepository<Language, UUID> {

}
