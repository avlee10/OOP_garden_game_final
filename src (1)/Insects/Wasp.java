package Insects;

import java.util.ArrayList;

public class Wasp extends Insects {

    public Wasp(int pos) {
        super(pos, .1, "Wasp", 0, .1, 1, 2);
        eatOnJumpChance = .5;
        diet = new String[]{};
        favPlants = new String[]{"azalea", "carnation", "cactus", "strawberry", "beanstalk", "tomato"};
        prey = new String[]{new Aphid(0).getiName(), new Caterpillar(0).getiName()};
    }

    public String[] getFavPlants() {
        return favPlants;
    }
}
