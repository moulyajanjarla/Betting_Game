package com.example.betting.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String game;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String outcome;

    @Column(nullable = false)
    private LocalDateTime timestamp;
}

