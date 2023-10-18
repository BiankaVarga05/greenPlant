package com.gfa.exam.betting;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contestant> contestants = new ArrayList<>();
        contestants.add(new Contestant("Contestant 1"));
        contestants.add(new Contestant("Contestant 2"));
        contestants.add(new Contestant("Contestant 3"));

        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1", 1000));
        players.add(new Player("Player 2", 2000));
        players.add(new Player("Player 3", 3000));
        players.add(new Player("Player 4", 1000));

        players.get(0).makeBet(contestants.get(0), 500);
        players.get(1).makeBet(contestants.get(1), 500);
        players.get(2).makeBet(contestants.get(2), 5000);
        players.get(2).makeBet(contestants.get(2), 1000);
        players.get(3).makeBet(contestants.get(1), 1000);

        new Race(contestants, players).startRace();
    }
}
