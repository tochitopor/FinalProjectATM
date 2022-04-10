package ru.tochitopor.atm.client.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;
import ru.tochitopor.atm.client.service.ClientService;
import ru.tochitopor.atm.common.GetBalanceReqstDTO;
import ru.tochitopor.atm.common.GetBalanceRespnsDTO;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class ClientControllerTest {
    @Mock
    private ClientService clientService;
    @Mock
    private RestTemplate restTemplate;

    private ClientController clientController;

    @BeforeEach
    void setUp() {
        restTemplate = Mockito.mock(RestTemplate.class);
        clientService = new ClientService();//Mockito.mock(ClientService.class);
        clientController = new ClientController(restTemplate, clientService);
    }

    @Test
    public void getATMInfoTest(){
        assertEquals( "Russian Moscow ATM Test 8081", clientController.getATMInfo());
    }

    @Test
    public void getClientBalanceSuccessTest(){
        long clientId = 1L;
        long scoreId  = 1L;
        int PIN = 1234;
        int balance = 1000;
        GetBalanceRespnsDTO response = new GetBalanceRespnsDTO(balance);

        when(restTemplate.postForObject(anyString(), any(), any()))
                .thenReturn(response);

        assertEquals(clientController.getClientBalance(clientId,scoreId,PIN), balance);
    }
}
