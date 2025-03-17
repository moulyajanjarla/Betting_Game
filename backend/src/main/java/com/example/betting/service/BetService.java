package com.example.betting.service;
import com.example.betting.model.Bet;
import com.example.betting.repository.BetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetService {

    private final BetRepository betRepository;

    public BetService(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    public List<Bet> getAllBets() {
        return betRepository.findAll();
    }
}
