package Himanshu.SnakeAndLadder;

import java.util.Scanner;

public class PlayGame {
    Player[] players;
    Board board;
    Dice dice;
    int turn = 0;

    PlayGame(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter first player's name");
        String name1 = sc.nextLine();
        players = new Player[2];
        players[0] = new Player(name1);
        System.out.println("Please enter second player's name");
        String name2 = sc.nextLine();
        players[1] = new Player(name2);

        board = new Board();
        dice = new Dice();
    }

    public void play(){
        while(!players[0].checkForWin() && !players[1].checkForWin()){

            System.out.println("Rolling the dice for " + players[turn].getName());

            int moves = dice.roll();
            int currPos = players[turn].getPos();
            int newPos = currPos;

            if(players[turn].getPos() + moves <= 100){
                newPos += moves;
                newPos = board.checkForSnakesAndLadders(newPos);
                players[turn].setPos(newPos);
            }

            if(currPos == newPos)
                System.out.println(players[turn].getName() + " got a " + moves + " and stays at " + newPos);

            else
                System.out.println(players[turn].getName() + " got a " + moves + " and moved from " + currPos + "to " + newPos);


            if(players[turn].checkForWin()){
                System.out.println(players[turn].getName() + " wins the game");
                return;
            }

            turn = 1 - turn;
        }

    }
}
