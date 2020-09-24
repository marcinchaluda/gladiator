package com.codecool.gladiator.model.gladiators;

import com.codecool.gladiator.util.RandomUtils;

public abstract class Gladiator {

    private final String name;
    private int baseHp;
    private final int baseSp;
    private final int baseDex;
    private int level;
    private int currentHp;

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    /**
     * Constructor for Gladiators
     *
     * @param name the gladiator's name
     * @param baseHp the gladiator's base Health Points
     * @param baseSp the gladiator's base Strength Points
     * @param baseDex the gladiator's base Dexterity Points
     * @param level the gladiator's starting Level
     */
    public Gladiator(String name, int baseHp, int baseSp, int baseDex, int level) {
        this.name = name;
        this.baseHp = baseHp;
        this.baseSp = baseSp;
        this.baseDex = baseDex;
        this.level = level;
        setCurrentHp(baseHp);
    }

    /**
     * @return HP multiplier of the gladiator subclass
     */
    protected abstract Multiplier getHpMultiplier();

    /**
     * @return SP multiplier of the gladiator subclass
     */
    protected abstract Multiplier getSpMultiplier();

    /**
     * @return DEX multiplier of the gladiator subclass
     */
    protected abstract Multiplier getDexMultiplier();

    /**
     * @return Gladiator's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the full name of the gladiator
     * assembled by the subtype and the name
     * (e.g. "Brutal Brutus" or "Archer Leo")
     *
     * @return the full name
     */
    public String getFullName() {
        // Todo
        return name;
    }

    public int levelUp() {
        return level++;
    }

    public int getLevel() {
        return level;
    }

    public int getBaseHp(Multiplier multiplier) {
        return (int) (baseHp * multiplier.getValue() * level);
    }

    public int getBaseSp(Multiplier multiplier) {
        return (int) (baseSp * multiplier.getValue() * level);
    }

    public int getBaseDex(Multiplier multiplier) {
        return (int) (baseDex * multiplier.getValue() * level);
    }

    public double decreaseHpBy() {
        return baseSp * RandomUtils.generateStrikeForce();
    }

    public int setCurrentHpAfterStrike(int injury) {
        return  currentHp -= injury;
    }

    public boolean isDead() {
        return getCurrentHp() <= 0;
    }

    public int getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(int baseHp) {
        this.baseHp = baseHp;
    }

    public int getBaseSp() {
        return baseSp;
    }

    public int getBaseDex() {
        return baseDex;
    }

    public void increaseLevel() {
        this.level++;
    }

    public enum Multiplier {
        Low(0.75),
        Medium(1.0),
        High(1.25);

        private final double value;

        Multiplier(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(getFullName())
                .append(" (")
                .append(getCurrentHp())
                .append("/")
                .append(getBaseHp())
                .append(" HP, ")
                .append(getBaseSp())
                .append(" SP, ")
                .append(getBaseDex())
                .append(" DEX, ")
                .append(getLevel())
                .append(" LVL)");
        return builder.toString();
    }
}
