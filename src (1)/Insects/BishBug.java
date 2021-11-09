package Insects;

import Plant.Plant;

public class BishBug extends Insects {

    public BishBug(int pos) {
        super(pos, .2, "BishBug", 4, .1, 1, 2);
        diet = new String[]{"cabbage", "carrot", "tomato", "strawberry", "azalea", "carnation", "cactus", "beanstalk"};
    }

    public String[] getDiet() {
        return new String[]{"cabbage", "carrot", "tomato", "strawberry", "azalea", "carnation", "cactus", "beanstalk"};
    }
}
