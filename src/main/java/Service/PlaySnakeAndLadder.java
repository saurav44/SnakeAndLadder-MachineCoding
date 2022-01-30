package Service;

import Model.Dice;
import Model.Entities;
import Model.Player;

import java.util.HashMap;
import java.util.List;

public class PlaySnakeAndLadder {

    Dice dice;
    Entities instance;
    List<Player> players;
    HashMap<String, Integer> playerLastPosition;
    int sizeOfBoard;

    public PlaySnakeAndLadder(int noOfDice, List<Player> players, int sizeOfBoard, Entities instance) {
        this.dice = new Dice(noOfDice);
        this.instance = instance;
        this.players = players;
        this.playerLastPosition = new HashMap<>();
        this.sizeOfBoard = sizeOfBoard;
    }

    public void playGame() {

        initializeAllPlayerStartValue();

        int currentPlayer = 0;
        HashMap<Integer, Integer> winner = new HashMap<>();
        int position = 0;

        while(position != players.size() - 1) {
            String player = players.get(currentPlayer).getName();
            StringBuilder s = new StringBuilder();
            s.append(player).append(" rolled a ");
            if(winner.get(currentPlayer) == null) {
                int diceNumber = dice.getDiceNumber();
                int endPosition = playerLastPosition.get(player) + diceNumber;
                if(checkDiceNumberLessThanBoardSize(player, diceNumber)) {
                    s.append(diceNumber).append(" and moved from ").append(playerLastPosition.get(player));
                    // check if there is snake
                    while(instance.getSnakes().get(endPosition) != null) {
                        endPosition = instance.getSnakes().get(endPosition);
                        s.append(" after bitten by snake ");
                    }
                    // check if there is ladder
                    while (instance.getLadders().get(endPosition) != null) {
                        endPosition = instance.getLadders().get(endPosition);
                        s.append(" after climbing ladder");
                    }

                    s.append(" to ").append(endPosition);

                    playerLastPosition.put(player, endPosition);
                    System.out.println(s);

                    if(isPlayerWon(player)) {
                        winner.put(currentPlayer, ++position);
                        System.out.println("\n*******************************");
                        System.out.println(player + " wins the game.");
                        System.out.println("*******************************\n");

                    }
                }
            }
            currentPlayer = (currentPlayer + 1) % players.size();

        }
        // if there are more than 2 players, display the position of players
        System.out.println("\n********* Result ***********");
        for(int key: winner.keySet()) {
            System.out.println(players.get(key).getName() + " - Position: " + winner.get(key));
        }
    }

    private boolean isPlayerWon(String player) {
        return playerLastPosition.get(player) == sizeOfBoard;
    }

    private boolean checkDiceNumberLessThanBoardSize(String player, int diceNumber) {
        return playerLastPosition.get(player) + diceNumber <= sizeOfBoard;
    }

    private void initializeAllPlayerStartValue() {
        for(int i = 0; i < players.size(); i++) {
            playerLastPosition.put(players.get(i).getName(), 0);
        }
    }
}
