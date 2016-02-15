package first_test;

/**
 * Created by bender on 13.01.16.
 */
public class Lemur extends Primate {

    public Lemur() {
        toBorn();
    }

    @Override
    void makeColony() {
        System.out.println("You won't believe, but right now I'm not establishing a colony, because I'm to cute.");
    }

    @Override
    void say() {
        System.out.println("A lemur say \"Ummmm-ha\"");
    }

    @Override
    public void walkOnTwoFeet() {
        System.out.println("A lemur can walk like King Julien XIII (from \"Madagaskar\", you know?)");
    }

    @Override
    void toBorn() {
        System.out.println("A cute lemur was born");
    }
}