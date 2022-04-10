package ru.tochitopor.atm.serever.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.tochitopor.atm.common.GetBalanceReqstDTO;
import ru.tochitopor.atm.common.GetBalanceRespnsDTO;
import ru.tochitopor.atm.server.controller.ServerController;
import ru.tochitopor.atm.server.entity.Client;
import ru.tochitopor.atm.server.entity.Score;
import ru.tochitopor.atm.server.service.ServerService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
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
    public void getHostsInfoTest(){
        assertEquals( "Russian Moscow Host Test 8082", serverController.getHostsInfo());
    }

    @Test
    public void getBalanceSuccessTest(){
        long clientId = 1L;
        long scoreId  = 1L;
        int PIN = 1234;
        int balance = 1000;

        Client client = new Client(clientId,PIN,null);
        Score score = new Score(scoreId,balance, client);
        client.setScores(new ArrayList<Score>(){{add(score);}});

        GetBalanceReqstDTO request = new GetBalanceReqstDTO(clientId,scoreId,PIN);

        when(serverService.getClient(anyLong())).thenReturn(client);
        when(serverService.getScore(client, request.getScoreId())).thenReturn(score);

        assertEquals(serverController.getBalance(request).getBalance(), balance);
    }
}
