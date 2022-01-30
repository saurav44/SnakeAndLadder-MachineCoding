package Model;

import java.util.HashMap;

public class Entities {

    HashMap<Integer, Integer> snakes;
    HashMap<Integer, Integer> ladders;

    public Entities() {
        snakes = new HashMap<>();
        ladders = new HashMap<>();
    }

    public HashMap<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setSnakes(int start, int end) {
        snakes.put(start, end);
    }

    public HashMap<Integer, Integer> getLadders() {
        return ladders;
    }

    public void setLadders(int start, int end) {
        ladders.put(start, end);
    }

}
