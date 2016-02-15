package first_test;

/**
 * Created by bender on 13.01.16.
 */
public class Condor extends Birds {
    public Condor() {
        makeNest();
    }

    @Override
    void makeNest() {
        System.out.println("first_test.Condor has nested. I've done this beautiful nest high in the mountains.");
    }

    @Override
    public void fly() {
        System.out.println("Fly like fearsome condor");
    }

    @Override
    void say() {
        System.out.println("first_test.Condor says \"Gha-Gha\"");
    }
}
