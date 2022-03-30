package ru.tochitopor.atm.client.service;

import org.springframework.stereotype.Service;
import ru.tochitopor.atm.common.ResponseDTO;

@Service
public class ClientService {
    public int getClientBalance(ResponseDTO response) {
        return response.getBalance();
    }
}
