package Insects;

public class GroundBeetle extends Insects {


    public GroundBeetle(int pos) {
        super(pos, .1, "GroundBeetle", 0, .1, 1, 2);
        eatOnJumpChance = .7;
        diet = new String[]{};
        favPlants = new String[]{"strawberry", "tomato", "cabbage", "carrot", "cactus", "beanstalk"};
        prey = new String[]{new PotatoBeetle(0).getiName(), new JapaneseBeetle(0).getiName()};
    }

    public String[] getFavPlants() {
        return favPlants;
    }
}
