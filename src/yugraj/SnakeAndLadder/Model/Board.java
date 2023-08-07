package yugraj.SnakeAndLadder.Model;

public class Board {
    private final int SIZE=100;
    private Cell board[] = new Cell[SIZE+1];


    public Board(){
        for(int i=1;i<=SIZE;i++){
            board[i] = new Cell(i,SnakeLadder.NONE);
        }
    }

    public void move(Player player,int steps){
        int diff = SIZE - player.getPosition();
        if(steps>diff) return;
        else if(steps == diff){
            player.setPosition(SIZE);
            return;
        }
        player.setPosition(player.getPosition()+steps);
        while(board[player.getPosition()].getSnakeLadder() != SnakeLadder.NONE){
            switch (board[player.getPosition()].getSnakeLadder()){
                case SNAKE -> System.out.println(player.getName()+" got bitten by "+SnakeLadder.SNAKE.toString());
                case LADDER -> System.out.println(player.getName()+" found a "+SnakeLadder.LADDER.toString());
            }
            player.setPosition(board[player.getPosition()].getEndPosition());
        }
    }

    public void setSnakeAndLadders(int start, int end){
        SnakeLadder snakeLadder = SnakeLadder.NONE;
        if(start<end)
            snakeLadder = SnakeLadder.LADDER;
        else
            snakeLadder = SnakeLadder.SNAKE;
        board[start].setValue(end,snakeLadder);
    }
    public int getSIZE(){
        return this.SIZE;
    }

}
