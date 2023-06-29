package dev.patika.week5assignment.repository;

import dev.patika.week5assignment.entity.AirLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirLineRepository extends CrudRepository<AirLine, Long> {
}
