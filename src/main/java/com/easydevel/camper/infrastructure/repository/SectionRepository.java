package com.easydevel.camper.infrastructure.repository;

import com.easydevel.camper.domain.model.Section;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends CrudRepository<Section, Long> {
}
