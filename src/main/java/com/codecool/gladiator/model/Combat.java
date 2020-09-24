package com.codecool.gladiator.model;

import com.codecool.gladiator.model.gladiators.Gladiator;
import com.codecool.gladiator.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Combat class, used for simulating fights between pairs of gladiators
 */
public class Combat {

    private final Gladiator gladiator1;
    private final Gladiator gladiator2;
    private final int DEAD = 0;
    private final int FIRST_MOVE = 0;

    private final List<String> combatLog;

    public Combat(Contestants contestants) {
        this.gladiator1 = contestants.gladiator1;
        this.gladiator2 = contestants.gladiator2;
        this.combatLog = new ArrayList<>();
    }

    /**
     * Simulates the combat and returns the winner.
     * If one of the opponents is null, the winner is the one that is not null
     * If both of the opponents are null, the return value is null
     *
     * @return winner of combat
     */
    public Gladiator simulate() {
        Gladiator player = RandomUtils.drawFirstPlayer() == FIRST_MOVE ? gladiator1 : gladiator2;
        player = isNullValue(player);

        while (!(player.isDead())) {
            attackEnemy(player);
            player = switchPlayer(player);
        }
        return player;
    }

    private Gladiator isNullValue(Gladiator player) {
        if (gladiator1 == null) {
            gladiator1.setBaseHp(DEAD);
            player = gladiator2;
        } else if (gladiator2 == null) {
            gladiator2.setBaseHp(DEAD);
            player = gladiator1;
        } else if (gladiator1 == null && gladiator2 == null) {
            return null;
        }
        return player;
    }

    private void attackEnemy(Gladiator player) {
        int percentageOfHit = getChanceOfHit(player);
        int tryToHit = RandomUtils.getPossibleHit();
        if (tryToHit <= percentageOfHit) {
            hitEnemy(player);
        } else {
            missEnemy(player);
        }
    }

    private void missEnemy(Gladiator player) {
        combatLog.add(String.format("%S missed", player.getName()));
    }

    private void hitEnemy(Gladiator player) {
        int wound = (int) player.decreaseHpBy();
        player = switchPlayer(player);
        player.setCurrentHpAfterStrike(wound);
        player = switchPlayer(player);
        combatLog.add(String.format("%S deals %d damage", player.getName(), wound));
    }

    private int getChanceOfHit(Gladiator player) {
        int dexterityDiff;
        int percentageOfHit;

        if (player == gladiator1) {
            dexterityDiff = player.getBaseDex() - gladiator2.getBaseDex();
        } else {
            dexterityDiff = player.getBaseDex() - gladiator1.getBaseDex();
        }
        percentageOfHit = RandomUtils.generateHitStrength(dexterityDiff);
        return percentageOfHit;
    }


    public Gladiator getGladiator1() {
        return gladiator1;
    }

    public Gladiator getGladiator2() {
        return gladiator2;
    }


    public String getCombatLog(String separator) {
        return String.join(separator, combatLog);
    }

    private Gladiator switchPlayer(Gladiator currentGladiator) {
        if (currentGladiator.equals(gladiator1)) {
            currentGladiator = gladiator2;
        } else if (currentGladiator.equals(gladiator2)) {
            currentGladiator = gladiator1;
        }
        return currentGladiator;
    }

}
