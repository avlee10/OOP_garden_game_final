package Insects;

public class LadyBug extends Insects {

    public LadyBug(int pos) {
        super(pos,.1, "LadyBug", 0, .1, 1, 2);
        eatOnJumpChance = .5;
        diet = new String[]{};
        favPlants = new String[]{"tomato", "cactus", "cabbage", "carrot", "azalea", "carnation"};
        prey = new String[]{new Aphid(0).getiName(), new BishBug(0).getiName()};
    }

    public String[] getFavPlants() {
        return favPlants;
    }
}
