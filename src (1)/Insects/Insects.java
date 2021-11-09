package Insects;
import Plant.Plant;
import java.lang.Math;
import java.util.*;
import java.awt.*;
import javax.swing.JButton;

public class Insects {
    public String[] prey = new String[]{};
    private double dieChance;
    private String name;
    private double damage;
    public String[] diet = new String[]{};
    public String[] favPlants = new String[]{};
    private double spawnChance;
    private int spawnAmountLowerBound;
    private int spawnAmountUpperBound;
    private int position;
    public int daysSinceMeal = 0;
    public double eatOnJumpChance = 0;

    // ------------ Constructor
    Insects (int pos, double diechance, String species, double dmg, double spawnRate, int spawnLB, int spawnUB) {
        dieChance = diechance;
        name = species;
        damage = dmg;
        spawnChance = spawnRate;
        spawnAmountLowerBound = spawnLB;
        spawnAmountUpperBound = spawnUB - spawnLB;
        position = pos;
    }

    public double getDieChance() {
        return dieChance;
    }
    public String getiName() {
        return name;
    }
    public String[] getDiet() { return diet; }
    public String[] getFavPlants() { return favPlants; }
    public double getDamage() { return damage; }
    public int getSpawnUB() { return spawnAmountUpperBound; }
    public int getSpawnLB() { return spawnAmountLowerBound; }
    public double getSpawnChance() { return spawnChance; }


    public boolean Move(HashMap<JButton, Plant> grid) {
        int gridDimension = (int) Math.sqrt(grid.size());
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        possibleMoves.add(position + 1);
        possibleMoves.add(position - 1);
        possibleMoves.add(position + 5);
        possibleMoves.add(position - 5);

        Random rnd = new Random();
        int newPosition = 0;
        int counter = 0;
        loop:
        while (possibleMoves.size() > 0) {
            newPosition = possibleMoves.get(rnd.nextInt(possibleMoves.size()));
            possibleMoves.remove(possibleMoves.indexOf(newPosition));
            // check to see if possible move would be legal
            if (newPosition <= 0 || newPosition > grid.size()) {
                continue;
            }
            if (newPosition % gridDimension == 1 && position % gridDimension == 0) {
                continue;
            }
            if (newPosition % gridDimension == 0 && position % gridDimension == 1) {
                continue;
            }

            // check to see if the insect would want to move there (is in diet or favPlants)
            for (Plant plt : grid.values()) {
                if (plt.getPosition() == newPosition && favPlants.length > 0) { // if predator
                    for (String n : favPlants) {
                        if (n.equals(plt.getName())) { // if in favPlants, add new Insect to Plant
                            Insects newInsect = null;
                            if (name.equals("Wasp")) {
                                newInsect = new Wasp(plt.getPosition());
                                newInsect.daysSinceMeal = daysSinceMeal;
                            }
                            else if (name.equals("Spider")) {
                                newInsect = new Spider(plt.getPosition());
                                newInsect.daysSinceMeal = daysSinceMeal;
                            }
                            else if (name.equals("Mantis")) {
                                newInsect = new Mantis(plt.getPosition());
                                newInsect.daysSinceMeal = daysSinceMeal;
                            }
                            else if (name.equals("GroundBeetle")) {
                                newInsect = new GroundBeetle(plt.getPosition());
                                newInsect.daysSinceMeal = daysSinceMeal;
                            }
                            else if (name.equals("LadyBug")) {
                                newInsect = new LadyBug(plt.getPosition());
                                newInsect.daysSinceMeal = daysSinceMeal;
                            }
                            plt.insectsOnPlant.add(newInsect);
                            return true;
                        }
                    }
                } else if (plt.getPosition() == newPosition){ // if plant eater
                    int count = 0;
                    while (count < 20) {
                        String food = diet[rnd.nextInt(diet.length)];
                            if (food.equals(plt.getName()) && newPosition != position) { // if in diet, add new Insect to Plant
                                if (name.equals("Aphid")) {
                                    plt.insectsOnPlant.add(new Aphid(newPosition));
                                } else if (name.equals("JapaneseBeetle")) {
                                    plt.insectsOnPlant.add(new JapaneseBeetle(newPosition));
                                } else if (name.equals("PotatoBeetle")) {
                                    plt.insectsOnPlant.add(new PotatoBeetle(newPosition));
                                } else if (name.equals("Caterpillar")) {
                                    plt.insectsOnPlant.add(new Caterpillar(newPosition));
                                } else if (name.equals("BishBug")) {
                                    plt.insectsOnPlant.add(new BishBug(newPosition));
                                }
                                return true;
                            }
                        count++;
                    }
                }
            }
            counter++;
        }
        return false;
    }

    public Insects eatOrDie(HashMap<JButton, Plant> grid) {
        Insects returner = null;
        if (favPlants.length > 0) { // get predators
            int newPosition = 0;
            Random rnd = new Random();
            int gridDimension = (int) Math.sqrt(grid.size());

            ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
            possibleMoves.add(position + 1);
            possibleMoves.add(position - 1);
            possibleMoves.add(position + gridDimension);
            possibleMoves.add(position - gridDimension);

            // loop to remove any illegal jumps
            int counter = 0;
            while (counter == 4) {
                int bound = possibleMoves.size();
                newPosition = possibleMoves.get(rnd.nextInt(bound));
                // check to see if possible move would be legal
                if (newPosition <= 0 ||
                        newPosition >= grid.size() ||
                        (newPosition % gridDimension == 1 && position % gridDimension == 0) ||
                        (newPosition % gridDimension == 0 && position % gridDimension == 1)) {
                    possibleMoves.remove(possibleMoves.indexOf(newPosition));
                }
                counter++;
            }
            // Start search for things to eat,
            // beginning with bugs on current plant, then venturing to neighboring plants
            for (Plant p : grid.values()) {
                // check if any prey on current plant
                if (p.getPosition() == position) {
                    loop:
                    for (Insects i : p.insectsOnPlant) {
                        for (String prey : prey) {
                            if (prey == i.getiName()) {
                                daysSinceMeal = -1;
                                returner = i;
                            }
                        }
                    }
                } else { // look at neighboring plants for things to eat and possibly eat them
                    ArrayList<Insects> insectsToRemove = new ArrayList<Insects>();
                    loop:
                    for (int pm : possibleMoves) {
                        if (p.getPosition() == pm) { // if plant is one of the possible move locations
                            for (Insects i : p.insectsOnPlant) {
                                for (String prey : prey) {
                                    if (i.getiName() == prey) {
                                        if (Math.random() < eatOnJumpChance) {
                                            p.insectsOnPlant.remove(i);
                                            daysSinceMeal = -1;
                                            break loop;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            daysSinceMeal++;
        }
        return returner;
    }
}