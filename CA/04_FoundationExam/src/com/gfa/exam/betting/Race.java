package com.gfa.exam.betting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Race {
    List<Contestant> contestants;
    List<Player> players;

    public Race(List<Contestant> contestants, List<Player> players) {
        this.contestants = contestants;
        this.players = players;
    }

    private List<Integer> generatePlacements() {
        List<Integer> placements = new ArrayList<>();

        while (placements.size() < contestants.size()) {
            Random random = new Random();
            int placement = 1 + random.nextInt(contestants.size());

            if (!placements.contains(placement)) {
                placements.add(placement);
            }
        }

        return placements;
    }

    public void startRace() {
        List<Integer> placements = generatePlacements();

        for (int i = 0; i < contestants.size(); i++) {
            Integer nextPlacement = placements.get(i);
            Contestant nextContestant = contestants.get(i);
            nextContestant.setPlacement(nextPlacement);
        }

        Collections.sort(contestants);

        for (Contestant contestant : contestants) {
            System.out.println(contestant);
        }

        Contestant winner = contestants.get(0);

        for (Player player : players) {
            for (Bet bet : player.getBets()) {
                if (bet.getContestant() == winner) {
                    int money = bet.getAmount() * 2;
                    player.addMoney(money);

                    String name = player.getName();
                    int betId = bet.getBetId();
                    System.out.println(name + " has won " + money + "$ with the bet: " + betId);
                }
            }
        }
    }
}
