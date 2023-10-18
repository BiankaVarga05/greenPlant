package com.gfa.exam.pirates;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private List<Pirate> crew = new ArrayList<>();
    private Captain captain;

    public boolean addPirate(Pirate pirate) {
        if (pirate instanceof Captain) {
            if (captain != null) {
                return false;
            }
            captain = (Captain) pirate;
        }

        crew.add(pirate);
        return true;
    }

    public int getCrewSize() {
        return crew.size();
    }

    public List<String> getPoorPirates() {
        List<String> poorPirateNames = new ArrayList<>();

        for (Pirate pirate : crew) {
            if (pirate.isPoor()) {
                poorPirateNames.add(pirate.getName());
            }
        }

        return poorPirateNames;
    }

    public int getTotalGold() {
        int sum = 0;

        for (Pirate pirate : crew) {
            sum += pirate.getGoldAmount();
        }

        return sum;
    }

    public void lastDayOnTheShip() {
        for (Pirate pirate : crew) {
            pirate.party();
        }
    }

    public void prepareForBattle() {
        for (Pirate pirate : crew) {
            for (int i = 0; i < 5; i++) {
                pirate.work();
            }
        }

        lastDayOnTheShip();
    }
}
