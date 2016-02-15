package first_test;

/**
 * Created by bender on 13.01.16.
 */
public class Ostrich extends Birds {
    public Ostrich() {
        makeNest();
    }

    @Override
    void makeNest() {
        System.out.println("first_test.Ostrich has nested. Hey look - I've done nothing. Does really ostriches make nests?");
    }

    @Override
    public void fly() {
        System.out.println("Fly like ostrich, I mean - not");
    }

    @Override
    void say() {
        System.out.println("first_test.Ostrich says \"Ugha-gha\"");
    }
}
