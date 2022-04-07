package ru.tochitopor.atm.serever.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.tochitopor.atm.server.entity.Client;
import ru.tochitopor.atm.server.entity.Score;
import ru.tochitopor.atm.server.exception.ClientNotFoundException;
import ru.tochitopor.atm.server.exception.InvalidPINException;
import ru.tochitopor.atm.server.exception.ScoreNotFoundException;
import ru.tochitopor.atm.server.repository.ClientCRUDRepository;
import ru.tochitopor.atm.server.service.ServerService;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;

import java.util.*;


public class ServerServiceTest {
    @Mock
    private ClientCRUDRepository clientCrudRepository;
    private ServerService serverService;

    @BeforeEach
    void setUp() {
        clientCrudRepository = Mockito.mock(ClientCRUDRepository.class);
        serverService = new ServerService(clientCrudRepository);
    }


    @Test
    //совершенно бессмысленный тест проверяющий перекладку объекта
    public void getClientSuccessTest() {
        long clientId = 1L;
        Client client = new Client(clientId,1234,null);
        Score score1 = new Score(1L,2000, client);
        client.setScores(new ArrayList<Score>(){{add(score1);}});

        Mockito.when(clientCrudRepository.findById(clientId))
                .thenReturn(Optional.of(client));

        assertEquals(client,
                serverService.getClient(clientId));

    }

    @Test
    //и еще один бессмысленный тест проверяющий перекладку объекта
    public void getClientFailureTest() {
        long clientId = 1L;
        Client client = new Client(clientId,1234,null);
        Score score1 = new Score(1L,2000, client);
        client.setScores(new ArrayList<Score>(){{add(score1);}});

        Mockito.when(clientCrudRepository.findById(anyLong()))
                .thenThrow(new ClientNotFoundException());

        ClientNotFoundException ex = assertThrows(ClientNotFoundException.class,()->
                serverService.getClient(clientId));

        assertEquals(ClientNotFoundException.class, ex.getClass());

    }

    @Test
    public void checkPINSuccessTest(){
        Client client = new Client(1L,1234,null);
        int PIN = 1234;

        assertTrue(serverService.checkPIN(client, PIN));
    }

    @Test
    public void checkPINFailureTest(){
        Client client = new Client(1L,1234,null);
        int PIN = 1235;

        InvalidPINException ex = assertThrows(InvalidPINException.class,()->
                serverService.checkPIN(client, PIN));

        assertEquals(InvalidPINException.class, ex.getClass());
    }

    @Test
    public void getScoreSuccesTest(){
        Client client = new Client(1L,1234,null);
        Score score1 = new Score(1L,2000, client);
        Score score2 = new Score(2L,1000, client);
        client.setScores(new ArrayList<Score>(){{add(score1);add(score2);}});
        int scoreId = 2;

        assertEquals(score2,serverService.getScore(client,scoreId));
    }

    @Test
    public void getScoreFailureTest(){
        Client client = new Client(1L,1234,null);
        Score score1 = new Score(1L,2000, client);
        Score score2 = new Score(2L,1000, client);
        client.setScores(new ArrayList<Score>(){{add(score1);add(score2);}});
        int scoreId = 3;

        ScoreNotFoundException ex = assertThrows(ScoreNotFoundException.class,()->
                serverService.getScore(client,scoreId));

        assertEquals(ScoreNotFoundException.class, ex.getClass());
    }
}
