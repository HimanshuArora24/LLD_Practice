package yugraj.TwoZeroFourEight;

import yugraj.TwoZeroFourEight.models.Board;
import yugraj.TwoZeroFourEight.models.PlayGame;

public class main {

    public static void main(String args[]){
        PlayGame playGame = new PlayGame();
        playGame.setup();
        playGame.play();
    }
}
