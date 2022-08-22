package domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nd4j.linalg.api.ndarray.INDArray;
//import org.nd4j.linalg.api.ndarray.INDArray;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vertex3D {
    Data3D data;

    public Vertex3D(float x, float y, float z) {
    this.data=new Data3D(x,y,z);
    }


    public Vertex3D(INDArray ia) {
        assert ia.length()==3;
        this.data=new Data3D(ia.getFloat(0),ia.getFloat(1),ia.getFloat(2));
    }


    public Vertex3D plus(Vector3D vector3D) {
        INDArray v1=this.data.extractIndarray();
        INDArray v2= vector3D.data.extractIndarray();
        INDArray sumIndArr = v1.add(v2);
        return new Vertex3D(sumIndArr);
    }

    public Vertex3D minus(Vector3D vector3D) {
        INDArray v1=this.data.extractIndarray();
        INDArray v2= vector3D.data.extractIndarray();
        INDArray sumIndArr = v1.sub(v2);
        return new Vertex3D(sumIndArr);
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
