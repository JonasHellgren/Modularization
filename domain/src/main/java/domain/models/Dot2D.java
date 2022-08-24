package domain.models;

import domain.utils.CommonMath;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

@Data
public class Dot2D {

    public static final int DELTA = 1;
    private int x,y;

    public Dot2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
        public boolean equals(Object other) {
            //check if the argument is a reference to this object
            if (other == this) return true;

            //check if the argument has the correct typ
            if (!(other instanceof Dot2D)) return false;

            //For each significant field in the class, check if that field matches the corresponding field of this object
            if (CommonMath.compareIntScalars(this.x, ((Dot2D) other).getX(), DELTA)) {
                return true;
            }

            return false;
        }

}
