package ru.tochitopor.atm.server.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tochitopor.atm.server.entity.Client;
import ru.tochitopor.atm.server.exception.ClientNotFoundException;
import ru.tochitopor.atm.server.repository.ClientCRUDRepository;
import ru.tochitopor.atm.server.repository.TempClientCrudRepository;

@Service
@AllArgsConstructor
public class ServerService {
    private ClientCRUDRepository clientCrudRepository = new TempClientCrudRepository();

    // serverService.getClient(clientId).getAccountDTO().get(0).getBalance()

    public Client getClient(Long id){
        return clientCrudRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }
}
