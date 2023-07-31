package Himanshu.SnakeAndLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    int BOARD_SIZE = 100;
    int[] board;
    Map<Integer,Integer> snakesAndLaddersPositioning = new HashMap<>();

    Board(){
        board = new int[BOARD_SIZE];

        for(int i = 1; i <= BOARD_SIZE; i++){
            board[i-1] = i;
        }
        placeSnakesAndLadders();
    }

    public void placeSnakesAndLadders(){
        List<SnakesLadders> AllSnakesLadders = new ArrayList<>();

//      Adding Ladders
        AllSnakesLadders.add(new SnakesLadders(9,14,snakesAndLaddersPositioning));
        AllSnakesLadders.add(new SnakesLadders(21,64,snakesAndLaddersPositioning));
        AllSnakesLadders.add(new SnakesLadders(45,93,snakesAndLaddersPositioning));
        AllSnakesLadders.add(new SnakesLadders(56,68,snakesAndLaddersPositioning));
        AllSnakesLadders.add(new SnakesLadders(65,71,snakesAndLaddersPositioning));

//      Adding Snakes
        AllSnakesLadders.add(new SnakesLadders(27,13,snakesAndLaddersPositioning));
        AllSnakesLadders.add(new SnakesLadders(61,49,snakesAndLaddersPositioning));
        AllSnakesLadders.add(new SnakesLadders(83,70,snakesAndLaddersPositioning));
        AllSnakesLadders.add(new SnakesLadders(97,41,snakesAndLaddersPositioning));
    }

    public int checkForSnakesAndLadders(int pos){
        int newPos;

        if(snakesAndLaddersPositioning.containsKey(pos)){
            newPos = snakesAndLaddersPositioning.get(pos);
            return newPos;
        }

        return pos;
    }

}
