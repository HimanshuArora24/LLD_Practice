package Himanshu.SnakeAndLadder;

public class Dice {
    int SIZE = 6;
    int out;

    public int roll(){
        double random = Math.random();
        out = (int)Math.floor(random * (SIZE));
        out++;
        return out;
    }
}
