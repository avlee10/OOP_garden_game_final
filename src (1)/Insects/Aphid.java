package Insects;

import Plant.Plant;

public class Aphid extends Insects {

    public Aphid(int pos) {
        super(pos, .2, "Aphid", .5, .5, 2, 5);
        diet = new String[]{"azalea", "carnation", "beanstalk", "strawberry"};
    }

    public String[] getDiet() {
        return new String[]{"azalea", "carnation", "beanstalk", "strawberry"};
    }
}
