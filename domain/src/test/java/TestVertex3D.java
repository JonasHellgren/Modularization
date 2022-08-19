import domain.models.Vector3D;
import domain.models.Vertex3D;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class TestVertex3D {

    public static final double DELTA = 0.01;

    @Test
    public void createVertex() {

        Vertex3D v=new Vertex3D(1,2,3);
        System.out.println("v = " + v);

        Assertions.assertAll(
                () -> assertEquals(1, v.getData().getX(), DELTA),
                () -> assertEquals(2, v.getData().getY(), DELTA),
                () -> assertEquals(3, v.getData().getZ(), DELTA)
        );

    }


    @Test
    public void plus() {
        Vertex3D v1= new Vertex3D(1f, 0f, 0f);
        Vector3D v2= new Vector3D(0f, 1f, 0f);
        Vertex3D vRes=v1.plus(v2);
        System.out.println("vRes = " + vRes);
        Assertions.assertAll(
                () -> assertEquals(1, vRes.getData().getX(), DELTA),
                () -> assertEquals(1, vRes.getData().getY(), DELTA),
                () -> assertEquals(0, vRes.getData().getZ(), DELTA)
        );
    }


    @Test
    public void minus() {
        Vertex3D v1= new Vertex3D(1f, 0f, 0f);
        Vector3D v2= new Vector3D(0f, 1f, 0f);
        Vertex3D vRes=v1.minus(v2);
        System.out.println("vRes = " + vRes);
        Assertions.assertAll(
                () -> assertEquals(1, vRes.getData().getX(), DELTA),
                () -> assertEquals(-1, vRes.getData().getY(), DELTA),
                () -> assertEquals(0, vRes.getData().getZ(), DELTA)
        );
    }


    @Test
    public void norm() {
        Vertex3D v1= new Vertex3D(1f, 2f, 0f);
        float norm=v1.norm();
        System.out.println("norm = " + norm);
        Assert.assertEquals(Math.sqrt(1+2*2+0),norm,DELTA);
    }


}
