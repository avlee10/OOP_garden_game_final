import java.util.HashMap;
import java.util.Random;

import Insects.*;
import Plant.*;

import javax.swing.*;

//make a method of EnvHazard to be called in GameLogic

public class EnvHazard {
    public static void doHazard() {
        Random rand = new Random(); //instance of Random class
        int upperbound = 15; // generate random values from 0-14
        int randint = rand.nextInt(upperbound);
        Plant[] gridPlants = gameScreen.grid.values().toArray(new Plant[gameScreen.grid.values().size()]);
        Random rnd = new Random();

        if (rnd.nextInt(3) == 3) {
            System.out.println("Rain");
            System.out.println("Rain pattered gently while you slept...");
            // for grid, increase water level for plants by a little
            for (Plant p : gridPlants) {
                p.setWaterLevel(p.getWaterLevel() + 10);
            }
        }
        System.out.println(randint);

        gameScreen.openStoreButton.setVisible(true); // to reset if E L O N event was triggered
        gameScreen.masterLog.add("\n\n*ENVIORNMENTAL HAZARD - DAY " + gameScreen.playerDay + "*");

        switch(randint)
        {
            case 0:
                gameScreen.masterLog.add("\nEvent: Meddling Kids!");
                gameScreen.masterLog.add("\nYou would've gotten away with it if it weren't for those meddling kids!");
                for (int i=0; i < 5; i++) {
                    int index = rnd.nextInt(25);
                    gridPlants[index].setHealth((int) (gridPlants[index].getHealth() - 25));
                }
                break;
            case 1:
                gameScreen.masterLog.add("\nEvent: Heavy Rain!");
                gameScreen.masterLog.add("\nNone of your plants are thirsty anymore, but some got overwatered and were damaged.");
                // for grid, increase water level for plants by a lot
                for (Plant p : gridPlants) {
                    int index = rnd.nextInt(5);
                    if (index == 5) {
                        p.setHealth((int) (gridPlants[index].getHealth() - 10));
                    }
                    p.setWaterLevel(100);
                }
                break;
            case 2:
                gameScreen.masterLog.add("\nEvent: Aphids Attack!");
                // Insects.Aphids();
                Integer aphidCount = rnd.nextInt(50) + 50;
                aphidCount += 10 - (aphidCount % 10);
                gameScreen.masterLog.add("\nOh lawd, they comin'! You got swarmed by " + aphidCount + " aphids last night!");
                for (int i=10; i <= aphidCount; i+=10) {
                    int index = rnd.nextInt(25);
                    for (int x=0; x < 10; x++) {
                        gridPlants[index].insectsOnPlant.add(new Aphid(index + 1));
                    }
                }
                break;
            case 3:
                gameScreen.masterLog.add("\nEvent: Caterpillars Attack!");
                Integer caterpillars = rnd.nextInt(4) + 8;
                gameScreen.masterLog.add("\n" + caterpillars + " caterpillars invaded your garden!!!");
                // for grid, pick random plant to stick it on
                for (int i=0; i < caterpillars; i+=1) {
                    int index = rnd.nextInt(25);
                    gridPlants[index].insectsOnPlant.add(new Caterpillar(index + 1));
                }
                break;
            case 4:
                gameScreen.masterLog.add("\nEvent: Bishbugs Attack!");
                Integer bishbugs = rnd.nextInt(4) + 8;
                gameScreen.masterLog.add("\n" + bishbugs + " bishbugs invaded your garden!!!");
                // for grid, pick random plant to stick it on
                for (int i=0; i < bishbugs; i+=1) {
                    int index = rnd.nextInt(25);
                    gridPlants[index].insectsOnPlant.add(new BishBug(index + 1));
                }
                break;
            case 5:
                gameScreen.masterLog.add("\nEvent: Japanese Beetles Attack!");
                // for grid, pick random plant to stick it on
                Integer jbeetles = rnd.nextInt(4) + 8;
                gameScreen.masterLog.add("\n" + jbeetles + " japanese beetles invaded your garden!!!");
                for (int i=0; i < jbeetles; i+=1) {
                    int index = rnd.nextInt(25);
                    gridPlants[index].insectsOnPlant.add(new JapaneseBeetle(index + 1));
                }
                break;
            case 6:
                gameScreen.masterLog.add("\nEvent: Potato Beetles Attack!");
                // for grid, pick random plant to stick it on
                Integer pbeetles = rnd.nextInt(4) + 8;
                gameScreen.masterLog.add("\n" + pbeetles + " potato beetles invaded your garden!!!");
                for (int i=0; i < pbeetles; i+=1) {
                    int index = rnd.nextInt(25);
                    gridPlants[index].insectsOnPlant.add(new PotatoBeetle(index + 1));
                }
                break;
            case 7:
                gameScreen.masterLog.add("\nEvent: Groundhogs Thanksgiving!");
                gameScreen.masterLog.add("\nSome groundhogs have a day feasting on your garden.");
                gameScreen.masterLog.add("\nAll your plants lose 10% health");
                // for grid, minus all plant health by 10%
                for (Plant p : gridPlants) {
                    p.setHealth((int) (p.getHealth() - 10));
                }
                break;
            case 8:
                gameScreen.masterLog.add("\nEvent: Wealthy Donors!");
                gameScreen.masterLog.add("\nWealthy donors see high potential in your garden and decide to invest [$$$] in your garden.");
                gameScreen.masterLog.add("\nYou receive [$$$].");
                // increase total money
                gameScreen.playerMoney += 500;
                break;
            case 9:
                gameScreen.masterLog.add("\nEvent: Tax Evasion!");
                gameScreen.masterLog.add("\nHalf your plants are indicted for tax evasion.");
                // lose half total money
                gameScreen.playerMoney = Math.round(gameScreen.playerMoney / 2);
                break;
            case 10:
                gameScreen.masterLog.add("\nEvent: Hottest Day of the Year!");
                gameScreen.masterLog.add("\nYour plants are cast as characters in Spike Lee's \"Do the Right Thing\" and are subject to the hottest day of the year.");
                gameScreen.masterLog.add("\nWater level for all plants is reduced by 25%.");
                // for grid, minus all plants by 25% waterlevel
                for (Plant p : gridPlants) {
                    p.setWaterLevel(p.getWaterLevel() - 25);
                }
                break;
            case 11:
                gameScreen.masterLog.add("\nEvent: Hungry Neighbor!");
                gameScreen.masterLog.add("\nOne of your neighbors locks themselves out of their house and decides to break into your garden and snack on your plants while they wait for a locksmith.");
                gameScreen.masterLog.add("\nTwo of your plants are complete eaten.");
                // for grid, remove two random plants
                break;
            case 12:
                gameScreen.masterLog.add("\nEvent: E L O N");
                gameScreen.masterLog.add("\nElon Musk says your garden is ugly on Twitter and you feel sad.");
                gameScreen.masterLog.add("\nYour confidence as well as your garden's image in the futures market plummet.");
                gameScreen.masterLog.add("\nYou really don't feel like going to the store today, so you can't buy anything.");
                gameScreen.openStoreButton.setVisible(false);
                break;
            case 13:
                gameScreen.masterLog.add("\nEvent: Inflation!");
                gameScreen.masterLog.add("\nDue to inflation, prices increase.");
                gameScreen.masterLog.add("\nPlant cost moving forward is increased 10%.");
                for (JButton option : gameScreen.storeOptions.keySet()) {
                    String[] newPrice = gameScreen.storeOptions.get(option);
                    newPrice[2] = String.valueOf(Double.parseDouble(newPrice[2]) * 1.1);
                    gameScreen.storeOptions.put(option, newPrice);
                }
        }
    }
}
