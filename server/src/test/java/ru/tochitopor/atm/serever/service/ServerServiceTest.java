package ru.tochitopor.atm.serever.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.tochitopor.atm.server.controller.ServerController;
import ru.tochitopor.atm.server.entity.Client;
import ru.tochitopor.atm.server.entity.Score;
import ru.tochitopor.atm.server.exception.ClientNotFoundException;
import ru.tochitopor.atm.server.exception.InvalidPINException;
import ru.tochitopor.atm.server.repository.ClientCRUDRepository;
import ru.tochitopor.atm.server.service.ServerService;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import static org.mockito.ArgumentMatchers.anyLong;


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
    public void getClientTest(){
        /*int clientID = 1;
        int scoreId  = 1;
        int PIN = 1234;
        int balance = 1000;

        Client client = new Client();
        client.setId((long) clientID);
        client.setPIN(PIN);

        List<Score> scores = Collections.singletonList(
                new Score((long) scoreId, balance, client)
        );

        client.setScores(scores);

        Mockito.when(clientCrudRepository.findById(anyLong()))
                .thenReturn(Optional.of(client));

        assertEquals(client,
                serverService.getClient(2));*/

    }

    @Test
    public void checkPINSuccessTest(){
        Client client = new Client();
        client.setId(1L);
        client.setPIN(1234);

        assertTrue(serverService.checkPIN(client, 1234));
    }

    @Test
    public void checkPINFailureTest(){
        Client client = new Client();
        client.setId(1L);
        client.setPIN(1234);

        InvalidPINException ex = assertThrows(InvalidPINException.class,()->
                serverService.checkPIN(client, 1235));

        assertEquals("Invalid PIN", ex.getMessage());
    }

    @Test
    public void getScoreTest(){
    }
}
