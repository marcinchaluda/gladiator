package com.codecool.gladiator.model.gladiators;

import com.codecool.gladiator.util.RandomUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GladiatorFactory {

    private List<String> names;

    public GladiatorFactory(String fileOfNames) {
        try {
            File file = new File(String.format("./src/main/resources/%s", fileOfNames));
            names = Files.readAllLines(file.toPath());
        } catch (IOException|NullPointerException e) {
            System.out.println("Names file not found or corrupted!");
            System.exit(1);
        }
    }

    /**
     * Picks a random name from the file given in the constructor
     *
     * @return gladiator name
     */
    private String getRandomName() {
        return names.get(RandomUtils.getRandomIndex(names));
    }

    /**
     * Instantiates a new gladiator with random name and type.
     * Creating an Archer, an Assassin, or a Brutal has the same chance,
     * while the chance of creating a Swordsman is the double of the chance of creating an Archer.
     * @return new Gladiator
     */
    public Gladiator generateRandomGladiator() {
        return drawGladiator();
    }

    private Gladiator drawGladiator() {
        HashMap<String, Integer> avatarStatistics = getAvatarStatistics();
        Gladiator avatar = null;
        int drawNumber = (int) Math.floor(Math.random() * 10);

        switch (drawNumber) {
            case 0: case 1: case 2: case 3:
                avatar = new Swordsman(getRandomName(), avatarStatistics.get("baseHp"), avatarStatistics.get("baseSp"),
                        avatarStatistics.get("baseDex"), avatarStatistics.get("level"));
                break;
            case 4: case 5:
                avatar = new Archer(getRandomName(), avatarStatistics.get("baseHp"), avatarStatistics.get("baseSp"),
                        avatarStatistics.get("baseDex"), avatarStatistics.get("level"));
                break;
            case 6: case 7:
                avatar = new Assassin(getRandomName(), avatarStatistics.get("baseHp"), avatarStatistics.get("baseSp"),
                        avatarStatistics.get("baseDex"), avatarStatistics.get("level"));
                break;
            case 8: case 9:
                avatar = new Brutal(getRandomName(), avatarStatistics.get("baseHp"), avatarStatistics.get("baseSp"),
                        avatarStatistics.get("baseDex"), avatarStatistics.get("level"));
                break;
        }
        return avatar;
    }

    private HashMap<String, Integer> getAvatarStatistics() {
        HashMap<String, Integer> avatarStatistics = new HashMap<>();
        avatarStatistics.put("baseHp", RandomUtils.getRandomValue());
        avatarStatistics.put("baseSp", RandomUtils.getRandomValue());
        avatarStatistics.put("baseDex", RandomUtils.getRandomValue());
        avatarStatistics.put("level", RandomUtils.getRandomLevel());
        return avatarStatistics;
    }

}
