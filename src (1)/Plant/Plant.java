package Plant;

import Insects.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Plant {
    // Instance Variables
    private String name;
    private double health;
    private int waterLevel; // water level
    private int thirst; // water used per day
    private int healthRegen; // environmental resistance
    private int cost;
    private String stats;
    private int position;

    public ArrayList<Insects> insectsOnPlant = new ArrayList<Insects>();

    // Constructors
    public Plant(int pos) {
        name = "*";
        health = 0;
        waterLevel = 0;
        healthRegen = 0;
        cost = 0;
        position = pos;
        ArrayList<String> susceptibleTo = new ArrayList<String>();
        ArrayList<String> attracts = new ArrayList<String>();
        stats = "Species: " + name +
                "\nHealth: " + health +
                "\nDaily Water consumption: " + thirst +
                "\nSusceptible to: " + susceptibleTo.toString() +
                "\nAttracts: " + attracts.toString();
    }

    public Plant(int pos, String[] species) {
        name = species[0];
        health = Integer.parseInt(species[1]);
        thirst = Integer.parseInt(species[2]);
        waterLevel = 100;
        healthRegen = Integer.parseInt(species[3]);
        cost = Integer.parseInt(species[4]);
        position = pos;
        ArrayList<String> susceptibleTo = new ArrayList<String>();
        ArrayList<String> attracts = new ArrayList<String>();

        Insects[] badInsects = {new Aphid(0),
                new JapaneseBeetle(0),
                new Caterpillar(0),
                new PotatoBeetle(0),
                new BishBug(0)
                };
        for (Insects i : badInsects) {
            if (Arrays.stream(i.getDiet()).anyMatch(name::equals)) {
                susceptibleTo.add(i.getiName());
            }
        }
        Insects[] goodInsects = {new Wasp(0),
                new GroundBeetle(0),
                new Mantis(0),
                new Spider(0),
                new LadyBug(0)};
        for (Insects i : goodInsects) {
            if (Arrays.stream(i.favPlants).anyMatch(name::equals)) {
                attracts.add(i.getiName());
            }
        }

        stats = "Species: " + name +
                "\nHealth: " + health +
                "\nDaily Water consumption: " + thirst +
                "\nSusceptible to: " + susceptibleTo.toString() +
                "\nAttracts: " + attracts.toString();
    }

    // Mutators
    public void setHealth(double h) { health = h; if (health > 100) { health = 100; } }
    public void setWaterLevel(int wr) { waterLevel = wr; }
    public void setHealthRegen(int er) { healthRegen = er; }
    public void setCost(int c) { cost = c; }

    // Accessors
    public String getName() { return name; }

    public double getHealth() { return health; }
    public int getWaterLevel() { return waterLevel; }
    public double getHealthRegen() { return healthRegen; }
    public int getCost() { return cost; }
    public String getStats() { return stats; }
    public int getThirst() { return thirst; }
    public int getPosition() { return position; }

    public static String[] strawberry = {"strawberry", "100", "5", "5", "10"};
    public static String[] azalea = {"azalea", "100", "5", "5", "10"};
    public static String[] carnation = {"carnation", "100", "5", "5", "10"};
    public static String[] tomato = {"tomato", "100", "5", "5", "10"};
    public static String[] beanstalk = {"beanstalk", "100", "5", "5", "10"};
    public static String[] cabbage = {"cabbage", "100", "5", "5", "10"};
    public static String[] carrot = {"carrot", "100", "5", "5", "10"};
    public static String[] moneytree = {"moneytree", "100", "5", "5", "10"};
    public static String[] cactus = {"cactus", "100", "5", "5", "10"};


    public String getInsectsOnPlant() {
        int waspCount = 0;
        int mantisCount = 0;
        int ladybugCount = 0;
        int gbeetleCount = 0;
        int spiderCount = 0;
        int aphidCount = 0;
        int jbeetleCount = 0;
        int caterpillarCount = 0;
        int potatobeetleCount = 0;
        int bishbugCount = 0;
        for (Insects i : insectsOnPlant) {
            if (i.getiName().equals("Wasp")) { waspCount++; }
            else if (i.getiName().equals("Mantis")) { mantisCount++; }
            else if (i.getiName().equals("GroundBeetle")) { gbeetleCount++; }
            else if (i.getiName().equals("LadyBug")) { ladybugCount++; }
            else if (i.getiName().equals("Spider")) { spiderCount++; }
            else if (i.getiName().equals("Aphid")) { aphidCount++; }
            else if (i.getiName().equals("Caterpillar")) { caterpillarCount++; }
            else if (i.getiName().equals("JapaneseBeetle")) { jbeetleCount++; }
            else if (i.getiName().equals("PotatoBeetle")) { potatobeetleCount++; }
            else if (i.getiName().equals("BishBug")) { bishbugCount++; }
        }
        return new String("Wasps: " + waspCount +
                "\nMantises: " + mantisCount +
                "\nGround Beetles: " + gbeetleCount +
                "\nLadybugs: " + ladybugCount +
                "\nSpiders: " + spiderCount +
                "\nAphids: " + aphidCount +
                "\nCaterpillars: " + caterpillarCount +
                "\nJapanese Beetles: " + jbeetleCount +
                "\nPotato Beetles: " + potatobeetleCount +
                "\nBishbugs: " + bishbugCount);
    }

    public int getSpawns(Insects i) {
        Random rnd = new Random();
        int insectCounter = 0;

        // These are the predators/good insects
        if (i.favPlants.length > 0) {
            for (String s : i.favPlants) {
                if (s == name) {
                    int upperBound = rnd.nextInt(i.getSpawnUB());
                    int possibleSpawns = upperBound + i.getSpawnLB();
                    for (int x=0; x<possibleSpawns; x++) {
                        if (Math.random() < i.getSpawnChance()) {
                            insectCounter++;
                        }
                    }
                }
            }
        // These are the plant eaters/bad insects
        } else {
            for (String s : i.getDiet()) {
                if (s == name) {
                    int upperBound = rnd.nextInt(i.getSpawnUB());
                    int possibleSpawns = upperBound + i.getSpawnLB();
                    for (int x=0; x<possibleSpawns; x++) {
                        if (Math.random() < i.getSpawnChance()) {
                            insectCounter++;
                        }
                    }
                }
            }
        }
        return insectCounter;
    }
}

