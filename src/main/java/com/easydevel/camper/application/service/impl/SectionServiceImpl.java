package com.easydevel.camper.application.service.impl;

import com.easydevel.camper.application.dto.SectionDto;
import com.easydevel.camper.application.dto.SectionMapper;
import com.easydevel.camper.application.service.SectionService;
import com.easydevel.camper.domain.exception.exception.NotFoundSectionException;
import com.easydevel.camper.domain.model.Section;
import com.easydevel.camper.infrastructure.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SectionServiceImpl implements SectionService {

    private final SectionRepository repository;

    private final SectionMapper mapper;

    @Autowired
    public SectionServiceImpl(SectionRepository repository, SectionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public SectionDto create(SectionDto sectionDto) {
        final Section section = mapper.toEntity(sectionDto);
        final Section createdSection = repository.save(section);

        return mapper.fromEntity(createdSection);
    }

    @Override
    @Cacheable(value = "section-cache", key = "'section-' + #id", unless = "#result == null || #result.id == null || #result.id == ''")
    public SectionDto findById(Long id) {
        final Section section = repository
                .findById(id)
                .orElseThrow(() -> new NotFoundSectionException(id));

        return mapper.fromEntity(section);
    }

}
