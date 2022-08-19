package domain.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
//import org.nd4j.linalg.api.ndarray.INDArray;
//import org.nd4j.linalg.factory.Nd4j;


@Data
@AllArgsConstructor
public class Data3D {

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


}
