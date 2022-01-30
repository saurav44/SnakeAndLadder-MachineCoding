import Model.Entities;
import Model.Player;
import Service.PlaySnakeAndLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int SIZE_OF_BOARD = 100;
        final int NO_OF_DICE = 1;
        Scanner scn = new Scanner(System.in);

        Entities instance = new Entities();

        int noOfSnakes = scn.nextInt();
        scn.nextLine();

        for(int i = 0; i < noOfSnakes; i++) {
            String[] snake = scn.nextLine().split(" ");
            int start, end;
            start = Integer.parseInt(snake[0]);
            end = Integer.parseInt(snake[1]);
            instance.setSnakes(start, end);
        }

        int noOfLadders = scn.nextInt();
        scn.nextLine();

        for(int i = 0; i < noOfLadders; i++) {
            String[] ladder = scn.nextLine().split(" ");
            int start, end;
            start = Integer.parseInt(ladder[0]);
            end = Integer.parseInt(ladder[1]);
            instance.setLadders(start, end);
        }

        int noOfPlayers = scn.nextInt();
        scn.nextLine();
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < noOfPlayers; i++) {
            String name = scn.nextLine();
            Player player = new Player(i, name);
            players.add(player);
        }

        PlaySnakeAndLadder playSnakeAndLadder = new PlaySnakeAndLadder(NO_OF_DICE, players, SIZE_OF_BOARD, instance);
        playSnakeAndLadder.playGame();

    }
}
