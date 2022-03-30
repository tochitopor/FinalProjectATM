package ru.tochitopor.atm.server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Client {
    private Long Id;
    private int PIN;
    private List<Score> scores;
}
