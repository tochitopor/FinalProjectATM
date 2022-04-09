package ru.tochitopor.atm.client.service;

import org.junit.jupiter.api.Test;
import ru.tochitopor.atm.client.service.ClientService;
import ru.tochitopor.atm.common.GetBalanceRespnsDTO;
import static org.junit.jupiter.api.Assertions.*;

public class ClientServiceTest {
    ClientService clientService = new ClientService();

    @Test
    //наверное методы с такой прозрачной логикой всё таки необязательно тестировать
    public void getClientBalanceSuccessTest(){
        assertEquals(clientService.getClientBalance(new GetBalanceRespnsDTO(3500)),3500);
    }
}
