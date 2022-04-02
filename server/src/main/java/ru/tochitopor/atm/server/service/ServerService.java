package ru.tochitopor.atm.server.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tochitopor.atm.server.entity.Client;
import ru.tochitopor.atm.server.entity.Score;
import ru.tochitopor.atm.server.exception.ClientNotFoundException;
import ru.tochitopor.atm.server.exception.InvalidPINException;
import ru.tochitopor.atm.server.repository.ClientCRUDRepository;

@Service
@AllArgsConstructor
public class ServerService {
    private ClientCRUDRepository clientCrudRepository;

    public Client getClient(int id){
        return clientCrudRepository.findById((long)id).orElseThrow(ClientNotFoundException::new);
    }

    public boolean checkPIN(Client client, int PIN){
        return client.getPIN() == PIN;
    }

    // этот метод надо будет переделать под jdbc
    public Score getScore(Client client, int scoreId){
        for(Score score : client.getScores()){
            if(score.getId() == scoreId)
                return score;
        }

        throw new InvalidPINException("Invalid scoreId");
    }
}
