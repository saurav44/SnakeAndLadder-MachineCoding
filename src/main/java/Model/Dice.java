package Model;

import java.util.Random;

public class Dice {

    private int noOfDice;
    private Random random;

    public Dice(int noOfDice) {
        this.noOfDice = noOfDice;
        this.random = new Random();
    }

    public int getDiceNumber() {
        // generate random number between min and max (inclusive)
        return random.nextInt(noOfDice*6 - noOfDice + 1) + noOfDice;
    }

}
