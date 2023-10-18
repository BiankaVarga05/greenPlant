package com.gfa.exam.betting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    String name;
    int account;
    List<Bet> bets = new ArrayList<>();

    public Player(String name, int account) {
        this.name = name;
        this.account = account;
    }

    public void makeBet(Contestant contestant, int amount) {
        if (account >= amount) {
            Bet bet = new Bet(amount, this, contestant);
            bets.add(bet);
            account -= amount;
        }
    }

    public void addMoney(int amount) {
        if (amount > 0) {
            account += amount;
        }
    }

    public String getName() {
        return name;
    }

    public List<Bet> getBets() {
        return bets;
    }
}
