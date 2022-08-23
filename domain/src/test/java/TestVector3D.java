//import domain.models.Vector3D;

import domain.models.Vector3D;
import org.junit.Assert;
import org.junit.Test;


public class TestVector3D {

    public static final double DELTA = 0.01;

    @Test
    public void crossProduct() {

        Vector3D v1= new Vector3D(1f, 0f, 0f);
        Vector3D v2= new Vector3D(0f, 1f, 0f);
        Vector3D vRes=v1.cross(v2);
       System.out.println("vRes = " + vRes);

        Assert.assertEquals(0, vRes.getData().getX(), DELTA);
        Assert.assertEquals(1, vRes.getData().getZ(), DELTA);
    }


    @Test public void divfloat() {

        Vector3D v1= new Vector3D(10f, 0f, 0f);
        Vector3D v2=v1.divWithScalar(10f);
        System.out.println("v2 = " + v2);

        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);

        Assert.assertEquals(1,v2.getData().getX(),0.1);


    }



}
