package ru.tochitopor.atm.server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Clients")
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue
    private Long Id;

    private int PIN;

    @OneToMany(mappedBy = "client_id")
    private List<Score> scores;
}
