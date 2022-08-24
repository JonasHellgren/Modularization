import domain.models.Vector3D;
import domain.models.Vertex3D;
import org.junit.Assert;
import org.junit.Test;
import viewservice.logic.WorldToCameraTransformer;
import viewservice.view_mediator.ViewMediator;

import java.util.Arrays;
import java.util.List;

public class TestWorldToCameraTransformer {


    public static final double DELTA = 0.01;
    public static final int R = 10;

    @Test
    public void constructorOkThetaZero()  {

        List<Vertex3D> vertexList = getVertex3DS();

        WorldToCameraTransformer wtct=new WorldToCameraTransformer(vertexList);
        ViewMediator mediator=new ViewMediator();
        mediator.setTheta(0);
        mediator.setR(R);
        wtct.setMediator(mediator);
        System.out.println("mediator.getR() = " + mediator.getR());
       // System.out.println("mediator.getM() = " + mediator.getM());
        Vector3D rDesired=new Vector3D(0,0,10);
        Assert.assertTrue(wtct.getrVector(mediator.getTheta(), mediator.getR()).equals(rDesired));
        Assert.assertEquals(-1,wtct.getM().getElementAsFloat(0,0), DELTA);
    }


    @Test
    public void constructorOkThetaPiDiv4()  {

        List<Vertex3D> vertexList = getVertex3DS();

        WorldToCameraTransformer wtct=new WorldToCameraTransformer(vertexList);
        ViewMediator mediator=new ViewMediator();
        mediator.setTheta((float) Math.PI/4);
        mediator.setR(R);
        wtct.setMediator(mediator);
        System.out.println("wtct.getR() = " + wtct.getrVector(mediator.getTheta(), mediator.getR()));
      //  System.out.println("wtct.getM() = " + wtct.getM());
        Vector3D rDesired=new Vector3D(7.0711f, 0, 7.0711f);
        Assert.assertTrue(wtct.getrVector(mediator.getTheta(), mediator.getR()).equals(rDesired));
        Assert.assertEquals(-0.7071,wtct.getM().getElementAsFloat(0,0), DELTA);
    }

    @Test
    public void transformToCameraThetaIsZero() {
        List<Vertex3D> vertexList = getVertex3DS();
        WorldToCameraTransformer wtct=new WorldToCameraTransformer(vertexList);
        ViewMediator mediator=new ViewMediator();
        mediator.setTheta(0);
        mediator.setR(R);
        wtct.setMediator(mediator);
        wtct.transform();
        List<Vertex3D> vertexListCamera = wtct.getUVNVertices();

        System.out.println("vertexListCamera = " + vertexListCamera);
        Vertex3D vDesired=new Vertex3D(0f, 0, 10f);
        Assert.assertTrue(vertexListCamera.get(0).equals(vDesired));

    }

    @Test
    public void transformToCameraThetaIsPiDiv4() {
        List<Vertex3D> vertexList = getVertex3DS();

        WorldToCameraTransformer wtct=new WorldToCameraTransformer(vertexList);
        ViewMediator mediator=new ViewMediator();
        mediator.setTheta((float) Math.PI/4);
        mediator.setR(R);
        wtct.setMediator(mediator);
        System.out.println("wtct.getR() = " + wtct.getrVector(mediator.getTheta(), mediator.getR()));
        wtct.transform();
        List<Vertex3D> vertexListCamera = wtct.getUVNVertices();

        System.out.println("vertexListCamera = " + vertexListCamera);
        Vertex3D vDesired1=new Vertex3D(0f, 0, 10f);
        Assert.assertTrue(vertexListCamera.get(0).equals(vDesired1));
        Vertex3D vDesired2=new Vertex3D(0.7071f, 0, 9.2929f);
        Assert.assertTrue(vertexListCamera.get(1).equals(vDesired2));

    }

    private List<Vertex3D> getVertex3DS() {
        return Arrays.asList(
                new Vertex3D(0,0,0),
                new Vertex3D(0,0,1),
                new Vertex3D(0,1,1)
        );
    }
}
