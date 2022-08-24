package domain.models;


import domain.utils.CommonMath;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.math3.linear.*;

import java.util.Arrays;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Data3D {

    public static final float DELTA = 0.01f;
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

        System.out.println("this = " + this);

        //check if the argument has the correct typ
        if (!(dataOther instanceof Data3D)) return false;

        System.out.println("dataOther = " + dataOther);

        System.out.println("(Arrays.equals(this.getDoubleArray(), dataOther.getDoubleArray())) = " + (Arrays.equals(this.getDoubleArray(), dataOther.getDoubleArray())));

        //For each significant field in the class, check if that field matches the corresponding field of this object
        if (CommonMath.compareArrays(this.getFloatArray(), dataOther.getFloatArray(),DELTA)) {
            return true;
        }

        return false;
    }



}
