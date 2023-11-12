package com.easydevel.camper.application.service;

import com.easydevel.camper.application.dto.SectionDto;
import com.easydevel.camper.application.dto.SectionMapper;
import com.easydevel.camper.application.service.impl.SectionServiceImpl;
import com.easydevel.camper.domain.exception.exception.NotFoundSectionException;
import com.easydevel.camper.domain.model.Section;
import com.easydevel.camper.infrastructure.repository.SectionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SectionServiceTest {

    @InjectMocks
    SectionServiceImpl service;

    @Mock
    SectionRepository repository;

    SectionMapper mapper = Mappers.getMapper(SectionMapper.class);

    @BeforeEach
    void setUp() {
        service = new SectionServiceImpl(repository, mapper);
    }

    @Test
    void shouldCreateSection() {
        when(repository.save(any(Section.class))).thenReturn(new Section(0L, "shoes"));

        SectionDto createdSection  = service.create(new SectionDto(null, "shoes"));

        assertEquals(createdSection.getId(), 0L, "id should be 0");
        assertEquals(createdSection.getName(), "shoes", "name should be shoes");
    }

    @Test
    void shouldGetSection() {
        when(repository.findById(any(Long.class))).thenReturn(Optional.of(new Section(0L, "shoes")));

        SectionDto section = service.findById(0L);

        assertEquals(section.getId(), 0L, "id should be 0");
        assertEquals(section.getName(), "shoes", "name should be shoes");
    }

    @Test
    void shouldGetSectionThrowsException() {
        when(repository.findById(any(Long.class))).thenReturn(Optional.empty());

        NotFoundSectionException exception = assertThrows(NotFoundSectionException.class, () -> service.findById(0L));

        assertEquals(exception.getMessage(), "Section not found with id 0", "message exception is not correct");
    }
}
