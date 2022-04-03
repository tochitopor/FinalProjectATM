package ru.tochitopor.atm.server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Clients")
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @javax.persistence.Id
    @GeneratedValue
    private Long Id;

    private int PIN;

    @OneToMany(mappedBy = "client_id")
    private List<Score> scores;
}
