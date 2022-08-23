package domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vertex3D {
    Data3D data;

    public Vertex3D(float x, float y, float z) {
    this.data=new Data3D(x,y,z);
    }


    public Vertex3D(double[] arr1d) {
        assert arr1d.length==3;
        this.data=new Data3D(arr1d);
    }


    public Vertex3D plus(Vector3D otherV) {
        RealVector rv1 = new ArrayRealVector(data.getDoubleArray(), false);
        RealVector rv2 = new ArrayRealVector(otherV.data.getDoubleArray(), false);
        rv1.add(rv2);
        return new Vertex3D(rv1.toArray());
    }

    public Vertex3D minus(Vector3D otherV) {

        RealVector rv1 = new ArrayRealVector(data.getDoubleArray(), false);
        RealVector rv2 = new ArrayRealVector(otherV.data.getDoubleArray(), false);
        rv1.subtract(rv2);
        return new Vertex3D(rv1.toArray());


    }

    //v=x*M=(M'*x')'
    //https://math.stackexchange.com/questions/1615793/how-to-multiply-a-vector-from-the-left-side-with-matrix
    public Vertex3D mult(Matrix M)  {
        Matrix Mtranspose=M.transpose();
        return Mtranspose.mult(this);
    }

    public float norm() {
        return  data.norm();
    }

    @Override
    public boolean equals(Object obj) {
        Vertex3D v=(Vertex3D) obj;
        return  data.equals(v.data);
    }


}
