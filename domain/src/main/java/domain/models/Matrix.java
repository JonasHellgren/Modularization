package domain.models;

import lombok.Getter;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

@Getter
public class Matrix {

    INDArray M;

    public Matrix(double[][] arr2Dim) {
        M = Nd4j.createFromArray(arr2Dim);
    }

    public Matrix(Vector3D v1, Vector3D v2, Vector3D v3) {

        double[][] arr2Dim = {
                {v1.data.x, v1.data.y, v1.data.z},
                {v2.data.x, v2.data.y, v2.data.z},
                {v3.data.x, v3.data.y, v3.data.z}};

        M = Nd4j.createFromArray(arr2Dim);
    }

    public Vertex3D mult(Vertex3D vertex3D) {
        INDArray resultV = M.mmul(vertex3D.data.extractIndarray());
        return new Vertex3D(resultV);
    }

    public long[] size() {
        return M.shape();
    }

    public float getFloat(long row, long col) {
        return M.getFloat(row,col);
    }

    public Matrix transpose() {
        INDArray mTranspose = M.transpose();
        double[][] arr2Dim=mTranspose.toDoubleMatrix();
        return new Matrix(arr2Dim);
    }

    @Override
    public String toString() {
        return M.toString();
    }
}
