package dev.patika.week5assignment.repository;

import dev.patika.week5assignment.entity.ExpeditionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpeditionTypeRepository extends CrudRepository<ExpeditionType, Long> {
}
