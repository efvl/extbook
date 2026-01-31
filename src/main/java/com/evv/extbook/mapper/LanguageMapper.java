package com.evv.extbook.mapper;

import com.evv.extbook.dto.LanguageDto;
import com.evv.extbook.entity.Language;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface LanguageMapper {

    LanguageDto toDto(Language entity);

    Language toEntity(LanguageDto dto);

}
