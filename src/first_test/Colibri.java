package first_test;

/**
 * Created by bender on 13.01.16.
 */
public class Colibri extends Birds {
    public Colibri() {
        makeNest();
    }

    @Override
    void makeNest() {
        System.out.println("first_test.Colibri has nested. Hey look - I've made this nest");
    }

    @Override
    public void fly() {
        System.out.println("Fly like colibri");
    }

    @Override
    void say() {
        System.out.println("first_test.Colibri says \"Fuit\'\"");
    }
}
