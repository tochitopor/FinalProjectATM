package ru.tochitopor.atm.common;

import lombok.Value;

@Value
public class GetBalanceReqstDTO {
    private final long clientId;
    private final long scoreId;
    private final int pin; // не знаю почему, но когда был PIN большими буквами json не хотел его читать
}
