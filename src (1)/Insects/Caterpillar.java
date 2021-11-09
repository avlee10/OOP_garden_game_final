package Insects;

import Plant.Plant;

public class Caterpillar extends Insects {

    public Caterpillar(int pos) {
        super(pos, .1, "Caterpillar", 2, .3, 1, 2);
        diet = new String[]{"cabbage", "carnations", "azalea", "tomato", "strawberry"};
    }

    public String[] getDiet() {
        return new String[]{"cabbage", "carnations", "azalea", "tomato", "strawberry"};
    }
}
