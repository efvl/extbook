package com.evv.extbook.mapper;

import com.evv.extbook.dto.CreateLanguageRequest;
import com.evv.extbook.dto.LanguageDto;
import com.evv.extbook.dto.LanguageResponse;
import com.evv.extbook.entity.Language;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface LanguageMapper {

    LanguageDto toDto(Language entity);

    Language toEntity(LanguageDto dto);

    @Mapping(target = "id", ignore = true)
    Language toEntity(CreateLanguageRequest request);

    LanguageResponse toResponse(Language language);

    @Mapping(target = "id", ignore = true)
    void updateEntity(CreateLanguageRequest request, @MappingTarget Language language);
}
