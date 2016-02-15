package first_test;

/**
 * Created by bender on 13.01.16.
 */
public class Macaque extends Primate {

    public Macaque() {
        toBorn();
    }

    @Override
    void makeColony() {
        System.out.println("You know, right now I'm establishing a colony.");
    }

    @Override
    void say() {
        System.out.println("A macaque say \"Uah ah ah\"");
    }

    @Override
    public void walkOnTwoFeet() {
        System.out.println("A macaque can walk");
    }

    @Override
    void toBorn() {
        System.out.println("A new monkey life was born");
    }
}
