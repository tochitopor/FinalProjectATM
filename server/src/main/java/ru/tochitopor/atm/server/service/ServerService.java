package ru.tochitopor.atm.server.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.tochitopor.atm.server.entity.Client;
import ru.tochitopor.atm.server.entity.Score;
import ru.tochitopor.atm.server.exception.ClientNotFoundException;
import ru.tochitopor.atm.server.exception.InvalidPINException;
import ru.tochitopor.atm.server.exception.ScoreNotFoundException;
import ru.tochitopor.atm.server.repository.ClientCRUDRepository;

@Service
@AllArgsConstructor
@Log
public class ServerService {
    private ClientCRUDRepository clientCrudRepository;

    public Client getClient(long id){
        return clientCrudRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    public boolean checkPIN(Client client, int PIN){
        if(client.getPIN() == PIN){
            return true;
        }
        String error = "Client " + client.getId() + ", Invalid PIN - " + PIN;
        log.info(error);
        throw new InvalidPINException(error);
    }

    public Score getScore(Client client, int scoreId){
        for(Score score : client.getScores()){
            if(score.getId() == scoreId)
                return score;
        }

        String error = "Client " + client.getId() + ", Invalid scoreId - " + scoreId;
        log.info(error);
        throw new ScoreNotFoundException(error);
    }
}
