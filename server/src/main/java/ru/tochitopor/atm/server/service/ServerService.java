package ru.tochitopor.atm.server.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.tochitopor.atm.server.entity.Client;
import ru.tochitopor.atm.server.entity.Score;
import ru.tochitopor.atm.server.exception.ClientNotFoundException;
import ru.tochitopor.atm.server.exception.InvalidPINException;
import ru.tochitopor.atm.server.repository.ClientCRUDRepository;

@Service
@AllArgsConstructor
@Log
public class ServerService {
    private ClientCRUDRepository clientCrudRepository;

    public Client getClient(int id){
        return clientCrudRepository.findById((long)id).orElseThrow(ClientNotFoundException::new);
    }

    public boolean checkPIN(Client client, int PIN){
        if(client.getPIN() != PIN){
            log.info("Invalid PIN - " + PIN);
            throw new InvalidPINException("Invalid PIN");
        }
        return true;
    }

    public Score getScore(Client client, int scoreId){
        for(Score score : client.getScores()){
            if(score.getId() == scoreId)
                return score;
        }

        throw new InvalidPINException("Invalid scoreId");
    }
}
