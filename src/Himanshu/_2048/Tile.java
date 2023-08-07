package Himanshu._2048;

public class Tile {
    private String value;

    String[] VALUES = new String[]{"2", "4", "8", "16", "32", "64","128","256","512","1024"};

    Tile(){
        this.value = randomValue();
    }

    Tile(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String randomValue(){
        int random = Math.random() > 0.8 ? 4 : 2;
        return String.valueOf(random);
    }

}
