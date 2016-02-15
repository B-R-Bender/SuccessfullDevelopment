package first_test;

/**
 * Created by bender on 13.01.16.
 */
public class AepyornisMaximus extends Birds {
    public AepyornisMaximus() {
        makeNest();
    }

    @Override
    void makeNest() {
        System.out.println("Aepyornis Maximus has nested. Damn \"English Scientists\", do I really existed?");
    }

    @Override
    public void fly() {
        System.out.println("Fly like Aepyornis maximus ... do they fly anyway?!");
    }

    @Override
    void say() {
        System.out.println("Aepyornis maximus says \"?????\"");
    }
}