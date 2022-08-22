package domain.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
//import org.nd4j.linalg.api.ndarray.INDArray;
//import org.nd4j.linalg.factory.Nd4j;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Data3D {

    public static final double DELTA = 0.01;
    float x;
    float y;
    float z;


    public Data3D(INDArray ia) {
        x=ia.getFloat(0);
        y=ia.getFloat(1);
        z=ia.getFloat(2);
    }

    public INDArray extractIndarray() {
        double[] arr1Dim = {x, y, z};
        return Nd4j.createFromArray(arr1Dim);
    }

    public float norm() {
        INDArray vIndArr=extractIndarray();
        INDArray prod = vIndArr.mmul(vIndArr);
        return (float) Math.sqrt(prod.getDouble(0));
    }

    public boolean equals(Data3D dataOther) {
        //check if the argument is a reference to this object
        if (dataOther == this) return true;

        //check if the argument has the correct typ
        if (!(dataOther instanceof Data3D)) return false;

        //For each significant field in the class, check if that field matches the corresponding field of this object
        if (this.extractIndarray().equalsWithEps(dataOther.extractIndarray(), DELTA)) {
            return true;
        }

        return false;
    }


}
