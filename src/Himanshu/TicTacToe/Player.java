package Himanshu.TicTacToe;

class Player{
    private String name;
    private char pratik;

    Player(String name, char pratik){
        this.name = name;
        this.pratik = pratik;
    }

    public String getName(){
        return this.name;
    }
    public char getPratik(){
        return this.pratik;
    }
}