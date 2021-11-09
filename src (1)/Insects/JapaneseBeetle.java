package Insects;

public class JapaneseBeetle extends Insects {

    public JapaneseBeetle(int pos) {
        super(pos, .2, "JapaneseBeetle", 2, .2, 1, 3);
        diet = new String[]{"strawberry", "tomato", "carrot", "beanstalk"};
    }

    public String[] getDiet() {
        return new String[]{"strawberry", "tomato", "carrot", "beanstalk"};
    }
}
