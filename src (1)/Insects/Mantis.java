package Insects;

public class Mantis extends Insects {

    public Mantis(int pos) {
        super(pos, .1, "Mantis", 0, .1, 1, 2);
        eatOnJumpChance = .7;
        diet = new String[]{};
        favPlants = new String[]{"tomato", "carnation", "azalea", "carrot", "beanstalk"};
        prey = new String[]{new JapaneseBeetle(0).getiName(), new Caterpillar(0).getiName()};
    }

    public String[] getFavPlants() {
        return favPlants;
    }
}
