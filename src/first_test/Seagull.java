package first_test;

/**
 * Created by bender on 13.01.16.
 */
public class Seagull extends Birds {
    public Seagull() {
        makeNest();
    }

    @Override
    void makeNest() {
        System.out.println("first_test.Seagull has nested. I've made this beautiful nest near the blue sea.");
    }

    @Override
    public void fly() {
        System.out.println("Fly like white seagull");
    }

    @Override
    void say() {
        System.out.println("A seagull says \"Mine-mine\"");
    }
}
