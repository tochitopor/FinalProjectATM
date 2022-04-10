package ru.tochitopor.atm.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.tochitopor.atm.server.entity.Client;

@Repository
public interface ClientCRUDRepository extends CrudRepository<Client,Long> {
}
