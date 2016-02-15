package first_test;

import java.util.ArrayList;

/**
 * Created by bender on 13.01.16.
 */
public class Zoo {

    ArrayList<Animals> myZoo = new ArrayList<>();

    public Zoo(int numOfAnimals) throws InterruptedException {
        System.out.println();
        for (int index = 0; index<numOfAnimals; index++){
            int rnd = (int)(Math.random()*10);
            myZoo.add(chooser(rnd));
            Thread.sleep(500);
        }
        System.out.println("\nYour zoo was created.\n");
    }

    public ArrayList<Animals> getMyZoo() {
        return myZoo;
    }

    private Animals chooser(int rnd) {
        switch (rnd){
            case 0: return new Seagull();
            case 1: return new AepyornisMaximus();
            case 2: return new Chimpanzee();
            case 3: return new Colibri();
            case 4: return new Condor();
            case 5: return new Gorilla();
            case 6: return new Lemur();
            case 7: return new Macaque();
            case 8: return new Marmoset();
            case 9: return new Ostrich();
            default: return null;
        }
    }
}
