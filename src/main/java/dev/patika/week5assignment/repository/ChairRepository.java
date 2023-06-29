package dev.patika.week5assignment.repository;

import dev.patika.week5assignment.entity.Chair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChairRepository extends CrudRepository<Chair, Long> {
    List<Chair> findByExpeditionId(long id);
}
