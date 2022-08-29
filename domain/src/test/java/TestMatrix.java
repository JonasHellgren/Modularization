import domain.models.Matrix;
import domain.models.Vector3D;
import domain.models.Vertex3D;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestMatrix {

    public static final double DELTA = 0.01;
    Matrix M;
    Vertex3D vertex3D;

    @Before
    @Test
    public void init() {
        M=createM();
        vertex3D =createVertex();
    }

    @Test
    public void createFromArray() {
        M=createM();
        System.out.println("M = " + M);
        Assert.assertEquals(3, M.size()[0] , DELTA);
        Assert.assertEquals(3, M.size()[1] , DELTA);
        Assert.assertEquals(1, M.getElementAsFloat(0,0) , DELTA);

    }

    @Test
    public void createFromVectors() {
        Vector3D v1=new Vector3D(1,2,3);
        Vector3D v2=new Vector3D(4,5,6);
        Vector3D v3=new Vector3D(7,8,9);

        System.out.println("v1 = " + v1);

        Matrix Mat=new Matrix(v1,v2,v3);
        System.out.println(Arrays.deepToString(Mat.getMarray()));

        Assert.assertEquals(3, Mat.size()[0] , DELTA);
        Assert.assertEquals(3, Mat.size()[1] , DELTA);
        Assert.assertEquals(1, Mat.getElementAsFloat(0,0) , DELTA);

    }

   @Test
    public void testMatrixVertexMult() {
        Vertex3D resultV = M.mult(vertex3D);
        System.out.println("resultV = " + resultV);
        Assert.assertEquals(1 + 2 * 2 + 3 * 3, resultV.getData().getX(), DELTA);
        Assert.assertEquals(4 + 5 * 2 + 6 * 3, resultV.getData().getY(), DELTA);
    }

    @Test
    public void transpose() {
        Matrix mTransp=M.transpose();

        System.out.println("M = " + M);
        System.out.println("mTransp = " + mTransp);

       Assertions.assertAll(
                () -> assertEquals(4, mTransp.getElementAsFloat(0, 1), DELTA),
                () -> assertEquals(5, mTransp.getElementAsFloat(1, 1), DELTA),
                () -> assertEquals(6, mTransp.getElementAsFloat(2, 1), DELTA)

        );

    }

    private Matrix createM() {

        double[][] arr2Dim = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}};
        return  new Matrix(arr2Dim);
    }

    private Vertex3D createVertex() {
        return new Vertex3D(1,2,3);
    }

}
