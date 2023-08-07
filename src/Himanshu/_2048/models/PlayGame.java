package Himanshu._2048.models;

import java.util.Scanner;

public class PlayGame {
    Board board;
    Scanner sc;
    public void setup(){
        board = new Board(4,4);
        sc = new Scanner(System.in);
    }
    public void play(){
    board.printBoard();
    System.out.println();
        while (true){
            System.out.println("Enter direction 1:Up, 2:Down, 3:Left, 4:Right");
            int dir = sc.nextInt();
            int win  = 0;
            if(dir == 1){
                win = board.move(Direction.UP);
            } else if (dir==2) {
                win = board.move(Direction.DOWN);
            } else if (dir==3) {
                win = board.move(Direction.LEFT);
            } else if (dir==4) {
                win = board.move(Direction.RIGHT);
            }else {
                System.out.println("Invalid Move");
            }
            board.printBoard();
            System.out.println();
            if(win == 1){
                System.out.println("You win the game");
                break;
            } else if (win == -1) {
                System.out.println("Game Over");
                break;
            }
        }

    }
}
