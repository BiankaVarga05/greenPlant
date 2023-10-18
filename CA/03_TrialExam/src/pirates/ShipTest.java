package com.gfa.exam.pirates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
    Ship ship;

    @BeforeEach
    void setUp() {
        ship = new Ship();
    }

    @Test
    void addPirateAddsOnlyOneCaptain() {
        Captain jack = new Captain("Jack");
        Captain davy = new Captain("Davy");

        assertTrue(ship.addPirate(jack));
        assertFalse(ship.addPirate(davy));

        assertEquals(1, ship.getCrewSize());
    }

    @Test
    void getPoorPiratesReturnsWoodenLeggedPiratesOnly() {
        Pirate alice = new Pirate("Alice");
        Pirate bob = new Pirate("Bob");
        ship.addPirate(alice);
        ship.addPirate(bob);
        bob.makeWoodenLeg();

        List<String> expected = Arrays.asList("Bob");

        assertEquals(expected, ship.getPoorPirates());
    }

    @Test
    void getTotalGoldReturnsTotalWealth() {
        Captain jack = new Captain("Jack");
        Pirate alice = new Pirate("Alice");
        ship.addPirate(jack);
        ship.addPirate(alice);
        jack.work();
        alice.work();

        assertEquals(4 + 1, ship.getTotalGold());
    }

    @Test
    void lastDayOnTheShipIncrementsHP() {
        Captain jack = new Captain("Jack");
        Pirate alice = new Pirate("Alice");
        ship.addPirate(jack);
        ship.addPirate(alice);

        ship.lastDayOnTheShip();

        assertEquals(20 + 5, jack.getHealthPoints());
        assertEquals(20 + 1, alice.getHealthPoints());
    }

    @Test
    void prepareForBattleIncrementsGoldAndDecrementsHP() {
        Captain jack = new Captain("Jack");
        Pirate alice = new Pirate("Alice");
        ship.addPirate(jack);
        ship.addPirate(alice);

        ship.prepareForBattle();

        assertEquals(5 * 4, jack.getGoldAmount());
        assertEquals(20 - 5 * 3 + 5, jack.getHealthPoints());
        assertEquals(5 * 1, alice.getGoldAmount());
        assertEquals(20 - 5 * 1 + 1, alice.getHealthPoints());
    }
}
