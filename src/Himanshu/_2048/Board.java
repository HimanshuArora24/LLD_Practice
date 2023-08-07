package Himanshu._2048;

import java.util.Arrays;

public class Board {
    private String WIN_VALUE = "2048";
    private int SIZE = 4;
    private String EMPTY = "-";
    private Tile[][] board;
    int emptyTiles;

    public Tile[][] getBoard() {
        return board;
    }

    public int getSIZE() {
        return SIZE;
    }

    Board(){
        board = new Tile[SIZE][SIZE];
        emptyTiles = SIZE*SIZE;

        for(int i = 0; i < SIZE; i++)
            Arrays.fill(board[i],new Tile("-"));

        initiateRandomPos();
        initiateRandomPos();
    }

    public String getEMPTY() {
        return EMPTY;
    }

    private void initiateRandomPos(){
        if(emptyTiles == 0) return;

        int pos = (int) (Math.random()*emptyTiles);
        emptyTiles-- ;

        for(int i=0;i<SIZE;i++)
            for(int j=0;j<SIZE;j++){
                if(board[i][j].getValue().equals("-")){
                    if(pos==0){
                        this.board[i][j] = new Tile();
                    }
                    pos--;
                }
            }
    }

//    private int[] getRandomBoardPos() {
//        int posR = (int)(Math.random() * SIZE);
//        int posC = (int)(Math.random() * SIZE);
//
//        return new int[]{posR,posC};
//    }

//    public boolean isFull(){
//        for(int i = 0; i < SIZE; i++){
//            for(int j = 0; j < SIZE; j++){
//                if(!board[i][j].equals(EMPTY))
//                    return false;
//            }
//        }
//        return true;
//    }

    public int checkWin(){
        if(emptyTiles == 0) return -1;

        for(int i=0;i<SIZE;i++)
            for(int j=0;j<SIZE;j++){
                if(this.board[i][j].getValue().equals(WIN_VALUE))
                    return 1;
            }

        return 0;
    }

    public void print() {
        for(Tile row[] : board) {
            for (Tile tile : row)
                System.out.print(tile.getValue() + " ");
            System.out.println();
        }
    }



    private void merge(int arr[],int sz){
        for(int i=0;i<sz;i++){
            if(arr[i]!=0 && i+1<sz && arr[i]==arr[i+1]){
                arr[i]=arr[i]*2;
                emptyTiles++;
                arr[i+1]=0;
                i++;
            }
        }
    }

    public void move(String move){
        switch (move){
            case "0" :
                moveLeft();
                initiateRandomPos();
                break;
            case "1":
                moveRight();
                initiateRandomPos();
                break;
            case "2":
                moveUp();
                initiateRandomPos();
                break;
            case "3":
                moveDown();
                initiateRandomPos();
                break;
            default:
                System.out.println("Invalid Move");
        }

    }

    private void moveUp(){
        int sz = SIZE;
        for(int i=0;i<sz;i++){
            int arr[] = new int[sz];
            int k=0;
            for(int j=0;j<sz;j++) {
                if (!board[j][i].getValue().equals("-"))
                    arr[k++] = Integer.parseInt(board[j][i].getValue());
            }
            merge(arr,k);
            int l=0;
            for(int j=0;j<SIZE;j++){
                if(l>=k){
                    board[j][i].setValue("-");
                    continue;
                }
                if(arr[l]!=0){
                    board[j][i].setValue(String.valueOf(arr[l]));
                }
                else{
                    j--;
                }
                l++;
            }
        }
    }

    private void moveDown(){
        int sz = SIZE;
        for(int i=0;i<sz;i++){
            int arr[]=new int[sz];
            int k=0;
            for(int j=SIZE-1;j>=0;j--) {
                if (!board[j][i].getValue().equals("-"))
                    arr[k++] = Integer.parseInt(board[j][i].getValue());
            }
            merge(arr,k);
            int l=0;
            for(int j=SIZE-1;j>=0;j--){
                if(l>=k){
                    board[j][i].setValue("-");
                    continue;
                }
                if(arr[l]!=0){
                    board[j][i].setValue(String.valueOf(arr[l]));
                }
                else{
                    j++;
                }
                l++;
            }
        }
    }
    private void moveRight(){
        int sz = SIZE;
        for(int i=0;i<SIZE;i++){
            int arr[]=new int[sz];
            int k=0;
            for(int j=SIZE-1;j>=0;j--) {
                if (!board[i][j].getValue().equals("-"))
                    arr[k++] = Integer.parseInt(board[i][j].getValue());
            }
            merge(arr,k);
            int l=0;
            for(int j=SIZE-1;j>=0;j--){
                if(l>=k){
                    board[i][j].setValue("-");
                    continue;
                }
                if(arr[l]!=0){
                    board[i][j].setValue(String.valueOf(arr[l]));
                }
                else{
                    j++;
                }
                l++;
            }
        }
    }
    private void moveLeft(){
        int sz = SIZE;
        for(int i=0;i<SIZE;i++){
            int arr[]=new int[sz];
            int k=0;
            for(int j=0;j<SIZE;j++) {
                if (!board[i][j].getValue().equals("-"))
                    arr[k++] = Integer.parseInt(board[i][j].getValue());
            }
            merge(arr,k);
            int l=0;
            for(int j=0;j<SIZE;j++){
                if(l>=k){
                    board[i][j].setValue("-");
                    continue;
                }
                if(arr[l]!=0){
                    board[i][j].setValue(String.valueOf(arr[l]));
                }
                else{
                    j--;
                }
                l++;
            }
        }
    }

}
