package com.evv.extbook.mapper;

import com.evv.extbook.dto.BookDto;
import com.evv.extbook.dto.BookResponse;
import com.evv.extbook.dto.CreateBookRequest;
import com.evv.extbook.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = LanguageMapper.class, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BookMapper {

    @Mapping(source = "language.id", target = "languageId")
    BookDto toDto(Book entity);

    @Mapping(source = "languageId", target = "language.id")
    Book toEntity(BookDto dto);

    // Create request → entity
    @Mapping(source = "languageId", target = "language.id")
    @Mapping(target = "id", ignore = true)
    Book toEntity(CreateBookRequest request);

    // Entity → response
    @Mapping(source = "language", target = "language")
    BookResponse toResponse(Book book);

}
