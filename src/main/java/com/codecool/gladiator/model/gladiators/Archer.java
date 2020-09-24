package com.codecool.gladiator.model.gladiators;

public class Archer extends Gladiator {

    public Archer(String name, int baseHp, int baseSp, int baseDex, int level) {
        super(name, baseHp, baseSp, baseDex, level);
    }

    @Override
    protected Multiplier getHpMultiplier() {
        return Multiplier.Medium;
    }

    @Override
    protected Multiplier getSpMultiplier() {
        return Multiplier.Medium;
    }

    @Override
    protected Multiplier getDexMultiplier() {
        return Multiplier.High;
    }

    @Override
    public String getFullName() {
        return "Archer " + super.getFullName();
    }
}
