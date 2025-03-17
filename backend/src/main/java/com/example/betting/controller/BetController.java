package com.example.betting.controller;
import com.example.betting.model.Bet;
import com.example.betting.service.BetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bets")
public class BetController {

    private final BetService betService;

    public BetController(BetService betService) {
        this.betService = betService;
    }

    @GetMapping
    public List<Bet> getBets() {
        return betService.getAllBets();
    }
}

