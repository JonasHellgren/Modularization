package domain.models;

import lombok.Getter;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import java.util.Arrays;

@Getter
public class Matrix {

    double[][] Marray;
    RealMatrix M;

    public Matrix(double[][] arr2Dim) {
        setFields(arr2Dim);
    }

    private void setFields(double[][] arr2Dim) {
        Marray = arr2Dim;
        M = MatrixUtils.createRealMatrix(arr2Dim);
    }

    public Matrix(Vector3D v1, Vector3D v2, Vector3D v3) {
        double[][] arr2Dim = {
                {(double) v1.data.x, (double) v1.data.y, (double) v1.data.z},
                {(double) v2.data.x, (double) v2.data.y, (double) v2.data.z},
                {(double) v3.data.x, (double) v3.data.y, (double) v3.data.z}};

        setFields(arr2Dim);
    }


    public Vertex3D mult(Vertex3D vertex3D) {
        RealVector rv = new ArrayRealVector(vertex3D.data.getDoubleArray());
        RealMatrix Mcopy = M.copy();
        RealVector vRes = Mcopy.operate(rv);
        return new Vertex3D(vRes.toArray());
    }

    public Matrix mult(Matrix mOther) {
        RealMatrix rmOther = MatrixUtils.createRealMatrix(mOther.getMarray());
        RealMatrix mRes=M.multiply(rmOther);
        return new Matrix(mRes.getData());

    }

    public long[] size() {

        return new long[]{(long) M.getRowDimension(), (long) M.getColumnDimension()};
    }

    public float getElementAsFloat(long row, long col) {
        return (float) M.getEntry((int) row,(int) col);
    }

    public Matrix transpose() {
        RealMatrix Mold = MatrixUtils.createRealMatrix(Marray);
        return new Matrix(Mold.transpose().getData());
    }

    @Override
    public String toString() {
        System.out.println("toString Marray = " + Arrays.deepToString(Marray));
        return Arrays.deepToString(Marray);
    }
}
