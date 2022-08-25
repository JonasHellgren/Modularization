package domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Line2D {
    private int x1,y1;
    private int x2,y2;

   // private Line2D EMPTY_LINE=new Line2D();

}
