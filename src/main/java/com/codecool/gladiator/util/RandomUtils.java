package com.codecool.gladiator.util;

import java.util.List;
import java.util.Random;

public class RandomUtils {

    private static final int MAX_STATS_VALUE = 100;
    private static final int MIN_STATS_VALUE = 25;
    private static final int MAX_LEVEL = 5;
    private static final int MIN_LEVEL = 1;
    private static final int FIRST_PLAYER = 0;
    private static final int SECOND_PLAYER = 1;
    private static final int MIN_STRENGTH = 10;
    private static final int MAX_STRENGTH = 100;
    private static final int MIN_HIT_PROBABILITY = 10;
    private static final int MAX_HIT_PROBABILITY = 100;
    private static final double MIN_STRIKE_FORCE = 0.1;
    private static final double MAX_STRIKE_FORCE = 0.5;

    private static final Random RANDOM = new Random();

    public static int getRandomIndex(List<String> names) {
        return RANDOM.nextInt(names.size());
    }

    public static int getRandomValue() {
        return RANDOM.nextInt(MAX_STATS_VALUE - MIN_STATS_VALUE) + MIN_STATS_VALUE;
    }

    public static int getRandomLevel() {
        return RANDOM.nextInt(MAX_LEVEL - MIN_LEVEL) + MIN_LEVEL;
    }

    public static int drawFirstPlayer() {
        return RANDOM.nextInt() <= 0.5 ? FIRST_PLAYER : SECOND_PLAYER;
    }

    public static int generateHitStrength(int dexterityDiff) {
        int hitStrength;
        if (dexterityDiff <= MIN_STRENGTH) {
            hitStrength = MIN_STRENGTH;
        } else if (dexterityDiff >= MAX_STRENGTH) {
            hitStrength = MAX_STRENGTH;
        } else {
            hitStrength = (int) Math.floor(dexterityDiff);
        }
        return hitStrength;
    }

    public static int getPossibleHit() {
        return RANDOM.nextInt(MAX_HIT_PROBABILITY - MIN_HIT_PROBABILITY) + MIN_HIT_PROBABILITY;
    }

    public static double generateStrikeForce() {
        return (MIN_STRIKE_FORCE + (RANDOM.nextDouble() * (MAX_STRIKE_FORCE - MIN_STRIKE_FORCE)));
    }
}
