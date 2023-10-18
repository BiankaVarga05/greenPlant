package com.gfa.exam.pirates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PirateTest {
    @Test
    void testToStringWithRealLeg() {
        Pirate pirate = new Pirate("Jack");

        assertEquals(
                "Hello, I'm Jack. I still have my real legs and 0 amount of gold.",
                pirate.toString()
        );
    }

    @Test
    void testToStringWithWoodenLeg() {
        Pirate pirate = new Pirate("Jack");
        pirate.makeWoodenLeg();

        assertEquals(
                "Hello, I'm Jack. I have a wooden leg and 0 amount of gold.",
                pirate.toString()
        );
    }
}
