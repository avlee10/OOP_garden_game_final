package Insects;

public class Spider extends Insects {

    public Spider(int pos) {
        super(pos, .1, "Spider", 0, .3, 1, 2);
        eatOnJumpChance = .7;
        diet = new String[]{};
        favPlants = new String[]{"strawberry", "cabbage", "beanstalk", "tomato", "azalea", "carnation"};
        prey = new String[]{new BishBug(0).getiName(), new JapaneseBeetle(0).getiName()};
    }

    public String[] getFavPlants() {
        return favPlants;
    }
}
