package yugraj.TwoZeroFourEight.models;

public class Board {
    private int xSize;
    private int ySize;
    private int board[][];
    private int EMPTY;
    private int winValue;


    private void merge(int arr[],int sz){
        for(int i=0;i<sz;i++){
            if(arr[i]!=0 && i+1<sz && arr[i]==arr[i+1]){
                arr[i]=arr[i]*2;
                EMPTY++;
                arr[i+1]=0;
                i++;
            }
        }
    }

    private void placeRandom(){
        int mn = 0,mx=EMPTY-1;
        int pos = (int)(Math.random()*(mx-mn+1)+mn);
        int value = (Math.random() > 0.95) ? 4 : 2;
        EMPTY-- ;
        for(int i=0;i<xSize;i++)
            for(int j=0;j<ySize;j++){
                if(this.board[i][j]==0){
                    if(pos==0){
                        this.board[i][j] = value;
                    }
                    pos--;
                }
            }
    }
    private int checkWin(){
        for(int i=0;i<xSize;i++)
            for(int j=0;j<ySize;j++){
                if(this.board[i][j] == this.winValue)
                    return 1;
            }
        if(EMPTY == 0) return -1;
        return 0;
    }

    public Board(int xSize, int ySize){
        this.winValue = 2048;
        this.xSize = xSize;
        this.ySize = ySize;
        EMPTY = xSize*ySize;
        this.board = new int[xSize][ySize];
        for(int i=0;i<xSize;i++)
            for(int j=0;j<ySize;j++)
                board[i][j]=0;
    }

    public int move(Direction direction){
        switch (direction){
            case UP -> moveUp();
            case DOWN -> moveDown();
            case LEFT -> moveLeft();
            case RIGHT -> moveRight();
        }
        placeRandom();
        return checkWin();
    }

    public void printBoard(){
        for(int i=0;i<xSize;i++){
            for(int j=0;j<ySize;j++){
                    if(this.board[i][j]!=0)
                        System.out.print(this.board[i][j]+" ");
                    else System.out.print(". ");
                }
                System.out.println();
            }
    }

    private void moveUp(){
        int sz = this.xSize;
        for(int i=0;i<ySize;i++){
            int arr[]=new int[sz];
            int k=0;
            for(int j=0;j<xSize;j++) {
                if (this.board[j][i] != 0)
                    arr[k++] = this.board[j][i];
            }
            merge(arr,k);
            int l=0;
            for(int j=0;j<xSize;j++){
                if(l>=k){
                    this.board[j][i] = 0;
                    continue;
                }
                if(arr[l]!=0){
                    this.board[j][i] = arr[l];
                }
                else{
                    j--;
                }
                l++;
            }
        }
    }

    private void moveDown(){
        int sz = this.xSize;
        for(int i=0;i<ySize;i++){
            int arr[]=new int[sz];
            int k=0;
            for(int j=xSize-1;j>=0;j--) {
                if (this.board[j][i] != 0)
                    arr[k++] = this.board[j][i];
            }
            merge(arr,k);
            int l=0;
            for(int j=xSize-1;j>=0;j--){
                if(l>=k){
                    this.board[j][i] = 0;
                    continue;
                }
                if(arr[l]!=0){
                    this.board[j][i] = arr[l];
                }
                else{
                    j++;
                }
                l++;
            }
        }
    }
    private void moveRight(){
        int sz = this.ySize;
        for(int i=0;i<xSize;i++){
            int arr[]=new int[sz];
            int k=0;
            for(int j=ySize-1;j>=0;j--) {
                if (this.board[i][j] != 0)
                    arr[k++] = this.board[i][j];
            }
            merge(arr,k);
            int l=0;
            for(int j=ySize-1;j>=0;j--){
                if(l>=k){
                    this.board[i][j] = 0;
                    continue;
                }
                if(arr[l]!=0){
                    this.board[i][j] = arr[l];
                }
                else{
                    j++;
                }
                l++;
            }
        }
    }
    private void moveLeft(){
        int sz = this.ySize;
        for(int i=0;i<xSize;i++){
            int arr[]=new int[sz];
            int k=0;
            for(int j=0;j<ySize;j++) {
                if (this.board[i][j] != 0)
                    arr[k++] = this.board[i][j];
            }
            merge(arr,k);
            int l=0;
            for(int j=0;j<ySize;j++){
                if(l>=k){
                    this.board[i][j] = 0;
                    continue;
                }
                if(arr[l]!=0){
                    this.board[i][j] = arr[l];
                }
                else{
                    j--;
                }
                l++;
            }
        }
    }
}
