package domain.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.math3.linear.*;

import java.util.Arrays;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Data3D {

    public static final double DELTA = 0.01;
    float x;
    float y;
    float z;


    public Data3D(double[] arr) {
        x=(float) arr[0];
        y=(float) arr[1];
        z=(float) arr[2];
    }

    public double[] getDoubleArray() {
        return new double[]{(double) x, (double) y, (double) z};
    }

    public float[] getFloatArray() {
        return new float[]{x, y, z};
    }

    public float norm() {
        RealVector v = new ArrayRealVector(getDoubleArray(), false);
        return (float) v.getNorm();
    }

    public boolean equals(Data3D dataOther) {
        //check if the argument is a reference to this object
        if (dataOther == this) return true;

        //check if the argument has the correct typ
        if (!(dataOther instanceof Data3D)) return false;

        //For each significant field in the class, check if that field matches the corresponding field of this object
        if (Arrays.equals(this.getDoubleArray(), dataOther.getDoubleArray())) {
            return true;
        }

        return false;
    }


}
