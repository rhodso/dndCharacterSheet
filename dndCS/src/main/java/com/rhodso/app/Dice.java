package com.rhodso.app;

import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int number;
    private int sides;
    private int modifier;

    /*
     * @param _strDiceRep the DR to make a dice object from
     */
    public Dice(String _strDiceRep) { // Formatted as XXdYY+/-ZZ
        String[] parts = _strDiceRep.split("d");
        String[] parts2 = parts[1].split("\\+");
        String[] parts3 = parts[1].split("-");

        if (parts.length < 2) {
            // Formatting incorrect, return default
            number = 1;
            sides = 20;
            modifier = 0;
        } else {
            number = Integer.parseInt(parts[0]);
            if (parts2.length == 1) { // Modifier is -ve or doesn't exist
                sides = Integer.parseInt(parts[1]);
                if (parts3.length == 1) {// Modifier doesn't exist
                    modifier = 0;
                } else { // Modifier is -ve
                    modifier = Integer.parseInt(parts2[0]);
                }
            } else { // Modifier is +ve
                sides = Integer.parseInt(parts2[0]);
                modifier = Integer.parseInt(parts2[1]);
            }
        }

    }

    public Dice(int _sides) { // Assume number of dice is 1 and modifier is 0
        sides = _sides;
        number = 1;
        modifier = 0;
    }

    public Dice(int _sides, int _number) { // Assume modifier is 0
        sides = _sides;
        number = _number;
        modifier = 0;
    }

    public Dice(int _sides, int _number, int _modifier) {
        sides = _sides;
        number = _number;
        modifier = _modifier;
    }

    public int roll() throws IllegalArgumentException {
        if (sides < 2) { // Sides too low
            throw new IllegalArgumentException("Sides too low");
        } else if (number < 1) { // Number of dice too low
            throw new IllegalArgumentException("Too few dice to roll");
        } else { // Number >= 1

            // Set total to 0
            int total = 0;
            for (int i = 0; i < number; i++) {
                // Get random number

                // Found a better way of doing RNG
                int n = ThreadLocalRandom.current().nextInt(1, sides + 1);

                // Plus it seemed to fix a but in weapon damage rolls, for soem reaon

                // Add number to total
                total += n;
            }
            // Add modifier and return total
            if (Settings.isCritFailsIgnoreMods() && total == 1) {
                return total;
            } else {
                total += modifier;
                return total;
            }
        }
    }

    public static int roll(int _sides) {
        Dice d = new Dice(_sides);
        return d.roll();
    }

    public static int roll(int _sides, int _number) {
        Dice d = new Dice(_sides, _number);
        return d.roll();
    }

    public static int roll(int _sides, int _number, int _modifier) {
        Dice d = new Dice(_sides, _number, _modifier);
        return d.roll();
    }

}
