package first_test;

/**
 * Created by bender on 13.01.16.
 */
public class Marmoset extends Primate {

    public Marmoset() {
        toBorn();
    }

    @Override
    void makeColony() {
        System.out.println("You won't believe, but right now I'm not establishing a colony, because I'm to dumb.\n Sorry guys.");
    }

    @Override
    void say() {
        System.out.println("A marmoset say \"Uyui-ha-ui-hu\"");
    }

    @Override
    public void walkOnTwoFeet() {
        System.out.println("A marmoset can walk like stupid monkey");
    }

    @Override
    void toBorn() {
        System.out.println("Another dumb marmoset was born");
    }
}