import domain.models.Parameter;
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
    static final float ALPHA=(float) Math.PI/4;
    static final float GAMMA=0;

    public static final float PIDIV4 = (float) Math.PI / 4;

    @Test
    public void constructorOkThetaZero()  {

        List<Vertex3D> vertexList = getVertex3DS();

        WorldToCameraTransformer wtct=new WorldToCameraTransformer();
        ViewMediator mediator = getViewMediator(vertexList,0,R,ALPHA,GAMMA);
        wtct.setMediator(mediator);
        System.out.println("mediator.getR() = " + mediator.getParValue("R"));
       // System.out.println("mediator.getM() = " + mediator.getM());
        Vector3D rDesired=new Vector3D(0,0,10);
        Assert.assertTrue(wtct.getVectorBetweenCameraAndWorldOrigo(mediator.getParValue("theta"), mediator.getParValue("gamma"), mediator.getParValue("R")).equals(rDesired));
        System.out.println("wtct.getM() = " + wtct.createM());
//        Assert.assertEquals(-1,wtct.getM().getElementAsFloat(0,0), DELTA);
    }




    @Test
    public void constructorOkThetaPiDiv4()  {

        List<Vertex3D> vertexList = getVertex3DS();

        WorldToCameraTransformer wtct=new WorldToCameraTransformer();
        ViewMediator mediator = getViewMediator(vertexList,PIDIV4,R,ALPHA,GAMMA);
        wtct.setMediator(mediator);
        System.out.println("wtct.getR() = " + wtct.getVectorBetweenCameraAndWorldOrigo(mediator.getParValue("theta"), mediator.getParValue("gamma"), mediator.getParValue("R")));
      //  System.out.println("wtct.getM() = " + wtct.getM());

        System.out.println("wtct.getrVector(mediator.getTheta(), mediator.getR()) = " + wtct.getVectorBetweenCameraAndWorldOrigo(mediator.getParValue("theta"), mediator.getParValue("gamma"), mediator.getParValue("R")));

        Vector3D rDesired=new Vector3D(7.0711f, 0, 7.0711f);
        Assert.assertTrue(wtct.getVectorBetweenCameraAndWorldOrigo(mediator.getParValue("theta"), mediator.getParValue("gamma"), mediator.getParValue("R")).equals(rDesired));
        Assert.assertEquals(-0.7071,wtct.createM().getElementAsFloat(0,0), DELTA);
    }

    @Test
    public void transformToCameraThetaIsZero() {
        List<Vertex3D> vertexList = getVertex3DS();
        WorldToCameraTransformer wtct=new WorldToCameraTransformer();
        ViewMediator mediator = getViewMediator(vertexList, 0,R,ALPHA,GAMMA);
        wtct.setMediator(mediator);
        List<Vertex3D> vertexListCamera=wtct.transform(vertexList);
//        List<Vertex3D> vertexListCamera = wtct.getUVNVertices();

        System.out.println("vertexListCamera = " + vertexListCamera);
        Vertex3D vDesired= getvDesired();
        Assert.assertTrue(vertexListCamera.get(0).equals(vDesired));

    }

    private Vertex3D getvDesired() {
        return new Vertex3D(0f, 0, 10f);
    }

    @Test
    public void transformToCameraThetaIsPiDiv4() {
        List<Vertex3D> vertexList = getVertex3DS();

        WorldToCameraTransformer wtct=new WorldToCameraTransformer();
        ViewMediator mediator = getViewMediator(vertexList, (float) Math.PI/4,R,ALPHA,GAMMA);
        wtct.setMediator(mediator);
        System.out.println("wtct.getR() = " + wtct.getVectorBetweenCameraAndWorldOrigo(mediator.getParValue("theta"), mediator.getParValue("gamma"), mediator.getParValue("R")));
//        wtct.transform();
  //      List<Vertex3D> vertexListCamera = wtct.getUVNVertices();

        List<Vertex3D> vertexListCamera=wtct.transform(vertexList);

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

    private ViewMediator getViewMediator(List<Vertex3D> vertexList, float theta, float R, float alpha, float gamma ) {
        ViewMediator mediator=new ViewMediator();
        mediator.setWorldVertices(vertexList);
        mediator.changeParameterValue(new Parameter("theta",theta,""));
        mediator.changeParameterValue(new Parameter("R",R,""));
        mediator.changeParameterValue(new Parameter("alpha",alpha,""));
        mediator.changeParameterValue(new Parameter("gamma",gamma,""));
        return mediator;
    }

}
