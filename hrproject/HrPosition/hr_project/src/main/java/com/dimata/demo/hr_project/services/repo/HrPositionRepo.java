package com.dimata.demo.hr_project.services.repo;

import com.dimata.demo.hr_project.models.table.HrPosition;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface HrPositionRepo extends R2dbcRepository<HrPosition, Long> {
  Mono<HrPosition> findById(long id);
}
