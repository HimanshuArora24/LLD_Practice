package yugraj.SnakeAndLadder.Model;

import java.io.IOException;
import java.util.Scanner;

public class PlayGame {

    private Player players[];
    private Board board;
    private Dice dice;
    private int playerCount;
    private int turn = 0;
    Scanner sc = new Scanner(System.in);
    public void setup(){
        board = new Board();
        dice = new Dice();
        turn = 0;
        System.out.println("Enter number of Snakes");
        int snakes = sc.nextInt();
        while((snakes--) > 0){
            System.out.println("Enter start and end point of snake");
            int start = sc.nextInt();
            int end = sc.nextInt();
            board.setSnakeAndLadders(start,end);
        }
        System.out.println("Enter number of Ladders");
        int ladders = sc.nextInt();
        while((ladders--) > 0){
            System.out.println("Enter start and end point of ladder");
            int start = sc.nextInt();
            int end = sc.nextInt();
            board.setSnakeAndLadders(start,end);
        }
        System.out.println("Enter number of players");
        playerCount = sc.nextInt();
        players = new Player[playerCount];
        System.out.print("Enter name of all players");
        sc.nextLine();
        for(int i=0;i<playerCount;i++){
            String name = sc.nextLine();
            players[i] = new Player(name, 1);
        }
    }

    public void play() {
        while(true){
            System.out.println(players[turn].getName()+"'s turn press Enter to roll die");
            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int steps = dice.roll();
            System.out.println(players[turn].getName()+" rolled a "+steps);
            board.move(players[turn],steps);

            System.out.println(players[turn].getName()+" reached "+players[turn].getPosition());
            if(players[turn].getPosition() == board.getSIZE()){
                System.out.println(players[turn].getName()+" Wins ");
                break;
            }
            turn = (turn+1)%playerCount;
        }
    }
}
