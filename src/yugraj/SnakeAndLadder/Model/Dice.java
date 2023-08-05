package yugraj.SnakeAndLadder.Model;

public class Dice {
    private int MIN_VALUE;
    private int MAX_VALUE;

    public Dice(){
        MIN_VALUE = 1;
        MAX_VALUE = 6;
    }

    public int roll(){
        int value = (int)(Math.random()*(MAX_VALUE-MIN_VALUE+1)+MIN_VALUE);
        return value;
    }
}
