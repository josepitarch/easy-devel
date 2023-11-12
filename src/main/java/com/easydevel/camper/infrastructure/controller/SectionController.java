package com.easydevel.camper.infrastructure.controller;

import com.easydevel.camper.application.dto.DataDto;
import com.easydevel.camper.application.dto.SectionDto;
import com.easydevel.camper.application.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/section/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
public class SectionController {

    @Autowired
    public SectionController(SectionService service) {
        this.service = service;
    }

    private final SectionService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<DataDto<SectionDto>> getSection(@PathVariable("id") long id) {
        final SectionDto section = service.findById(id);

        return ResponseEntity.ok(new DataDto<>(section));
    }

    @PostMapping
    public ResponseEntity<DataDto<SectionDto>> createSection(@RequestBody SectionDto sectionDto) {
        final SectionDto createdSection = service.create(sectionDto);

        return ResponseEntity.ok(new DataDto<>(createdSection));
    }

}
