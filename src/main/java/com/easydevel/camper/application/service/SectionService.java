package com.easydevel.camper.application.service;

import com.easydevel.camper.application.dto.SectionDto;

public interface SectionService {

    SectionDto create(SectionDto section);
    SectionDto findById(Long id);
}
