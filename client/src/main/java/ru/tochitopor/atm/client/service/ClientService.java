package ru.tochitopor.atm.client.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tochitopor.atm.common.GetBalanceRespnsDTO;

@Service
@AllArgsConstructor
public class ClientService {
    public int getClientBalance(GetBalanceRespnsDTO response) {
        return response.getBalance();
    }
}
