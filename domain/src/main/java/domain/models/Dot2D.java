package domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Dot2D {

    private int x,y;


    public Dot2D(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("y = " + y);
    }
}
