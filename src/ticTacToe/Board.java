package ticTacToe;


import java.util.Arrays;

class Board{
    private int SIZE=3;
    private char board[][] = new char[SIZE][SIZE];
    private char EMPTY = ' ';

    public Board(){
        for(int i=0;i<SIZE;i++)
            Arrays.fill(board[i],EMPTY);
    }

    private boolean isValid(int x, int y){
        if(x<0 || y<0 || x>=SIZE || y>=SIZE){
            return false;
        }
        if(board[x][y]!=EMPTY)return false;

        return true;
    }

    public boolean place(int x ,int y, char piece){
        x--;
        y--;

        if(isValid(x,y)){
            board[x][y]=piece;
            return true;
        }
        return false;
    }
    public boolean isFull(){
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(board[i][j]==EMPTY)
                    return false;
            }
        }
        return true;
    }
    public boolean check(int x, int y, char piece){
        x--;
        y--;

        int c=0;
        for(int j=0;j<SIZE;j++){
            if(board[x][j]==piece)
                c++;
        }
        if(c==SIZE)return true;
        c=0;
        for(int j=0;j<SIZE;j++){
            if(board[j][y]==piece)
                c++;
        }
        if(c==SIZE)return true;

        if(x==y){
            c=0;
            for(int j=0;j<SIZE;j++){
                if(board[j][j]==piece)
                    c++;
            }
            if(c==SIZE)return true;
        }
        if(x+y ==SIZE-1){
            c=0;
            for(int j=0;j<SIZE;j++){
                if(board[j][SIZE-j-1]==piece)
                    c++;
            }
            if(c==SIZE)return true;
        }
        return false;
    }

    public void printBoard(){
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                System.out.print(board[i][j]);
                if(j!=SIZE-1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i!=SIZE-1)
                System.out.println("---------------------");
        }
    }

}