package yugraj.SnakeAndLadder.Model;

public class Cell {
    private int endPosition;
    SnakeLadder snakeLadder;
    public Cell(int endPosition, SnakeLadder snakeLadder){
        this.endPosition = endPosition;
        this.snakeLadder = snakeLadder;
    }
    public void setValue(int endPosition,SnakeLadder snakeLadder){
        this.endPosition = endPosition;
        this.snakeLadder = snakeLadder;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public SnakeLadder getSnakeLadder() {
        return snakeLadder;
    }
}
