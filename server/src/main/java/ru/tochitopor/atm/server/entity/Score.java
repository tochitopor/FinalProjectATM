package ru.tochitopor.atm.server.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Scores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Score {
    @Id
    @GeneratedValue
    private Long id;

    private int balance;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
}
