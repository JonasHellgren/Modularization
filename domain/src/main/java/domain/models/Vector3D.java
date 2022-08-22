package domain.models;

import domain.utils.CommonMath;
import lombok.Data;
import org.nd4j.linalg.api.ndarray.INDArray;
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

    public Vector3D reverse() {  //todo clean up with INdatrray method
        INDArray v=data.extractIndarray();
        float v1 = v.getFloat(0);
        float v2 = v.getFloat(1);
        float v3 = v.getFloat(2);
        return new Vector3D(-v1,-v2,-v3);
    }

    public Vector3D divWithScalar(float denom) {

        assert !CommonMath.isZero(denom);

        INDArray ia=data.extractIndarray();
        INDArray ia2=ia.div(denom);
        Data3D data3D=new Data3D(ia2);
        return new Vector3D(data3D);
    }

    public Vector3D cross(Vector3D vOther) {
        INDArray vRes=vectorCross(data.extractIndarray(), vOther.data.extractIndarray());
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

    public float norm() {
        return  data.norm();
    }

    @Override
    public boolean equals(Object obj) {
        Vector3D v=(Vector3D) obj;
        return  data.equals(v.data);
    }



}
