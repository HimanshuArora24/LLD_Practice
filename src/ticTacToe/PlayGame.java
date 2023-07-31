package ticTacToe;

import java.util.Scanner;

class PlayGame{
    private int PLAYERS_SIZE = 2;
    private Board board;
    private Player player[] = new Player[PLAYERS_SIZE];
    private static int turn;
    Scanner sc = new Scanner(System.in);

    PlayGame(){

        System.out.println("Please Input Player 1 pratik and name");
        String pl1[] = sc.nextLine().split(" ");
        player[0] = new Player(pl1[1],pl1[0].charAt(0));

        System.out.println("Please Input Player 2 pratik and name");
        String pl2[] = sc.nextLine().split(" ");
        player[1] = new Player(pl2[1],pl2[0].charAt(0));

        board = new Board();

        turn = 0;
        board.printBoard();
    }

    public void play(){
        while(!board.isFull()){
            System.out.println("Enter coordinates for player "+player[turn].getName());
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(board.place(x,y,player[turn].getPratik())){
                board.printBoard();
                if(board.check(x,y,player[turn].getPratik())){
                    System.out.println(player[turn].getName()+" wins");
                    return;
                }

                turn = 1 - turn;
            }
            else{
                System.out.println("Jldi yaha se hato");
            }
        }
        System.out.println("Game Draw");
    }
}