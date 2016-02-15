package first_test;

/**
 * Created by bender on 13.01.16.
 */
public class Chimpanzee extends Primate {


    public Chimpanzee() {
        toBorn();
    }

    @Override
    void makeColony() {
        System.out.println("You won't believe, but right now I'm establishing a colony.");
    }

    @Override
    void say() {
        System.out.println("A chimpanzee say \"Uh-ah-ha\"");
    }

    @Override
    public void walkOnTwoFeet() {
        System.out.println("A chimpanzee can walk like human");
    }

    @Override
    void toBorn() {
        System.out.println("A funny chimpanzee was born");
    }
}