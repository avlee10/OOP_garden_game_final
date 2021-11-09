package Insects;

public class PotatoBeetle extends Insects {

    public PotatoBeetle(int pos) {
        super(pos, .2, "PotatoBeetle", 2, .3, 1, 2);
        diet = new String[]{"cactus", "carrot", "cabbage", "carnation", "azalea"};
    }

    public String[] getDiet() {
        return new String[]{"cactus", "carrot", "cabbage", "carnation", "azalea"};
    }
}
