package domain.models;

import domain.utils.CommonMath;
import lombok.Data;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

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

    public Vector3D(double[] arr1d) {
        this(new Data3D(arr1d));
    }


    public Vector3D reverse() {  //todo clean up with INdatrray method
        float[] v=data.getFloatArray();
        return new Vector3D(-v[0],-v[1],-v[2]);
    }

    public Vector3D divWithScalar(float denom) {
        assert !CommonMath.isZero(denom);
        RealVector rv = new ArrayRealVector(data.getDoubleArray());
        rv.mapDivideToSelf(denom);
        return new Vector3D(rv.toArray());
    }

    public Vector3D cross(Vector3D vOther) {
        double[] vRes=vectorCross(data.getDoubleArray(), vOther.data.getDoubleArray());
        Data3D data=new Data3D(vRes);
        return new Vector3D(data);
    }


    //https://en.wikipedia.org/wiki/Cross_product
    private double[] vectorCross(double[] a, double[] b) {
        double a1= a[0];
        double a2= a[1];
        double a3= a[2];

        double[][] arr2Dim = {
                {0.0, -a3, a2},
                {a3, 0.0, -a1},
                {-a2, a1, 0.0}};

        RealMatrix M = MatrixUtils.createRealMatrix(arr2Dim);
        RealVector v = new ArrayRealVector(b, false);
        RealVector vRes = M.operate(v);
        return vRes.toArray();

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
