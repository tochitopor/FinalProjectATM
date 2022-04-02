package ru.tochitopor.atm.common;

import lombok.Value;

@Value
public class GetBalanceReqstDTO {
    private final int clientId;
    private final int scoreId;
    private final int pin; // не знаю почему, но когда был PIN большими буквами json не хотел его читать
}
