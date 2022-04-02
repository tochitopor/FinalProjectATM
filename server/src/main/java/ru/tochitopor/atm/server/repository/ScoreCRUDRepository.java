package ru.tochitopor.atm.server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.tochitopor.atm.server.entity.Score;

public interface ScoreCRUDRepository extends CrudRepository<Score,Long> {
}
