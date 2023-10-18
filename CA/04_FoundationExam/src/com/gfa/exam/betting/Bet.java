package com.gfa.exam.betting;

import java.util.Random;

public class Bet {
    int betId;
    int amount;
    Player player;
    Contestant contestant;

    public Bet(int amount, Player player, Contestant contestant) {
        this.amount = amount;
        this.player = player;
        this.contestant = contestant;

        Random random = new Random();
        betId = random.nextInt(9000) + 1000;
    }

    public int getBetId() {
        return betId;
    }

    public int getAmount() {
        return amount;
    }

    public Player getPlayer() {
        return player;
    }

    public Contestant getContestant() {
        return contestant;
    }
}
