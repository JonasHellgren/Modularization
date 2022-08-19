package domain.models;

import lombok.Data;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.factory.Nd4j;

@Data
public class Vector3D {
    Data3D data;
  // INDArray ind;

    public Vector3D(float x, float y, float z) {
        this.data = new Data3D(x, y, z);
    }

    public Vector3D(Data3D data) {
        this.data=data;
    }


    public Vector3D cross(Vector3D vOther) {
        INDArray vRes=vectorCross(data.getIndarray(), vOther.data.getIndarray());
        Data3D data=new Data3D(vRes);
        return new Vector3D(data);
    }


    //https://en.wikipedia.org/wiki/Cross_product
    private INDArray vectorCross(INDArray a, INDArray b) {
        double a1 = a.getDouble(0);
        double a2 = a.getDouble(1);
        double a3 = a.getDouble(2);

        double[][] arr2Dim = {
                {0.0, -a3, a2},
                {a3, 0.0, -a1},
                {-a2, a1, 0.0}};

        INDArray M = Nd4j.createFromArray(arr2Dim);

        return M.mmul(b);

    }



}
