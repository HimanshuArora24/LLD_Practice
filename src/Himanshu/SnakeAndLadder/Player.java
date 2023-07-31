package Himanshu.SnakeAndLadder;

public class Player {
    private String name;
    private int pos;

    public Player(String name) {
        this.name = name;
        this.pos = 0;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public boolean checkForWin(){
        if(pos == 100)
            return true;

        return false;
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

}
