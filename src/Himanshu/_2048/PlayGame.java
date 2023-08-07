package Himanshu._2048;

import java.util.Scanner;

public class PlayGame {
    Board board;
    int win = 0;


    PlayGame(){
        System.out.println("Game starts");
        board = new Board();
        board.print();
    }

    public void play(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println();
            System.out.println("Please enter next move (0 denotes left, 1 denotes right, 2 denotes top, 3 denotes bottom)");

            String move = sc.nextLine();

            board.move(move);

            board.print();

            int win = board.checkWin();

            if(win == 1){
                System.out.println("You win the game");
                break;
            }
            else if (win == -1) {
                System.out.println("Game Over");
                break;
            }

        }
    }
}
