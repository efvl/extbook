package com.evv.extbook.mapper;

import com.evv.extbook.dto.CreateWordRequest;
import com.evv.extbook.dto.WordResponse;
import com.evv.extbook.entity.Word;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface WordMapper {

    // CreateWordRequest → Word
    @Mapping(source = "bookId", target = "book.id")
    @Mapping(target = "id", ignore = true)
    Word toEntity(CreateWordRequest request);

    // Word → WordResponse
    @Mapping(source = "book.id", target = "bookId")
    WordResponse toResponse(Word word);

}
