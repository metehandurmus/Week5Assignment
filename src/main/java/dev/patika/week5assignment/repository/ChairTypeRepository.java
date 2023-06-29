package dev.patika.week5assignment.repository;

import dev.patika.week5assignment.entity.ChairType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChairTypeRepository extends CrudRepository<ChairType, Long> {
}
