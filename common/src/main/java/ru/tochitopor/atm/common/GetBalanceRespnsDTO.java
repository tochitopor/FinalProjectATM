package ru.tochitopor.atm.common;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor // без этого конструктора не создается объект респонс в рестТемплейте
@Getter
@Setter
@ToString
public class GetBalanceRespnsDTO {
    private int balance;
}
