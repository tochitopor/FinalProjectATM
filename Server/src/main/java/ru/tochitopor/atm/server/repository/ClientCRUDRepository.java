package ru.tochitopor.atm.server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.tochitopor.atm.server.entity.Client;

public interface ClientCRUDRepository extends CrudRepository<Client,Long> {
}
