package com.rhodso.app;

import java.time.Instant;
import java.util.Random;

public class Dice {
    private int number;
    private int sides;
    private int modifier;

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
        } else if (number == 1) { // Number is 1
            // Pick random number
            // Random random = new Random(Instant.now().getEpochSecond());
            // int n = random.nextInt(sides + 1);
            // n += 1;
            // n += modifier;
            // return n;
        } else { // Number > 1
            // Pick random number seeded by the current time
            Random random = new Random(Instant.now().getEpochSecond());

            // Set total to 0
            int total = 0;
            for (int i = 0; i < number; i++) {
                // Get random number
                int n = random.nextInt(sides + 1); // Add 1 to "Sides", then 1 to result so that the
                                                   // random number is in
                                                   // range 1-sides
                n += 1;

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
        // If something goes wrong, return 0
        return 0;
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
