package first_test;

/**
 * Created by bender on 13.01.16.
 */
public class Gorilla extends Primate {

    public Gorilla() {
        toBorn();
    }

    @Override
    void makeColony() {
        System.out.println("You won't believe, but right now I'm establishing a colony.");
    }

    @Override
    void say() {
        System.out.println("A gorilla say \"Uagrh-ghh-h\"");
    }

    @Override
    public void walkOnTwoFeet() {
        System.out.println("A gorilla can walk fast");
    }

    @Override
    void toBorn() {
        System.out.println("A big-little gorilla was born");
    }
}