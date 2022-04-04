package ru.tochitopor.atm.serever.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.tochitopor.atm.common.GetBalanceReqstDTO;
import ru.tochitopor.atm.server.controller.ServerController;
import ru.tochitopor.atm.server.entity.Client;
import ru.tochitopor.atm.server.entity.Score;
import ru.tochitopor.atm.server.service.ServerService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ServerControllerTest {
    @Mock
    private ServerService serverService;

    private ServerController serverController;

    @BeforeEach
    void setUp() {
        serverService = Mockito.mock(ServerService.class);
        serverController = new ServerController(serverService);
    }

    @Test
    public void getHostsInfo(){
        assertEquals( "Russian Moscow Host Test 8082", serverController.getHostsInfo());
    }

    @Test
    public void getBalanceTestClientIdExist(){
      /*  int clientID = 1;
        int scoreId  = 1;
        int PIN = 1234;
        int balance = 1000;

        Client client = new Client();
        Score score = new Score();
        score.setId((long)scoreId);
        score.setBalance(balance);
        score.setClient_id(client);
        List<Score> scores = new ArrayList<>();
        scores.add(score);
        client.setId((long) clientID);
        client.setPIN(PIN);
        client.setScores(scores);

        GetBalanceReqstDTO request = new GetBalanceReqstDTO(clientID,scoreId,PIN);

        Mockito.when(accountService.findByCardNumber(account.getCardNumber())).thenReturn(Optional.of(account));
        when(serverService.getClient(request.getClientId())).thenReturn(client);
        //when(serverService.checkPIN(client,request.getPin()).thenReturn(true);

       // serverController.getBalance(request);*/


    }
}
