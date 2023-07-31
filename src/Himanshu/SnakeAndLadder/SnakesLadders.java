package Himanshu.SnakeAndLadder;

import java.util.Map;

public class SnakesLadders {
    int start;
    int end;
    private String role;

    public String getRole() {
        return role;
    }

    SnakesLadders(int start, int end, Map<Integer,Integer> map){
        this.start = start;
        this.end = end;

        if(start < end)
            this.role = "Ladder";

        else if(end < start)
            this.role = "Snake";

        map.put(start,end);
    }
}
