package com.easydevel.camper.application.dto;

import com.easydevel.camper.domain.model.Section;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SectionMapper {

    SectionDto fromEntity(Section section);

    @Mapping(target = "id", ignore = true)
    Section toEntity(SectionDto sectionDto);
}
