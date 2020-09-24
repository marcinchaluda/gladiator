package com.codecool.gladiator.model.gladiators;

public class Swordsman extends Gladiator {

    public Swordsman(String name, int baseHp, int baseSp, int baseDex, int level) {
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
        return Multiplier.Medium;
    }

    @Override
    public String getFullName() {
        return "Swordsman " + super.getFullName();
    }


}
