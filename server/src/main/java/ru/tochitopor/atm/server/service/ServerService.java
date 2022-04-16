package ru.tochitopor.atm.server.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    public Score getScore(Client client, long scoreId){
        for(Score score : client.getScores()){
            if(score.getId() == scoreId)
                return score;
        }

        String error = "Client " + client.getId() + ", Invalid scoreId - " + scoreId;
        log.info(error);
        throw new ScoreNotFoundException(error);
    }

    // When we use findById() to retrieve an entity within a transactional method,
    // the returned entity is managed by the persistence provider.  So, any change
    // to that entity will be automatically persisted in the database, regardless
    // of whether we are invoking the save() method.
    @Transactional
    public Score setScore(long clientId, long scoreId, int balance){
        Client client = getClient(clientId);
        Score score = null;

        for(Score s : client.getScores()){
            if(s.getId() == scoreId){
                s.setBalance(balance);
                score = s;
            }
        }

        if(score == null) {
            String error = "Client " + client.getId() + ", Invalid scoreId - " + scoreId;
            log.info(error);
            throw new ScoreNotFoundException(error);
        }

        return score;
    }
}
