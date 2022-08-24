import domain.models.Vertex3D;
import org.junit.Assert;
import org.junit.Test;
import viewservice.logic.UVNCoordinateProjector;
import viewservice.view_mediator.ViewMediator;

import java.util.Arrays;
import java.util.List;

public class TestUVNCoordinateProjector {

    public static final int R = 10;
    static final float ALPHA=(float) Math.PI/4;
    public static final float PIDIV4 = (float) Math.PI / 4;

    @Test
    public void transformToCameraThetaIsZero() {
        List<Vertex3D> vertexList = getVertexThetaIsZero();
        UVNCoordinateProjector projector=new UVNCoordinateProjector();
        ViewMediator mediator = getViewMediator(PIDIV4,R,ALPHA);
        mediator.setUVNVertices(vertexList);
        projector.setMediator(mediator);

        projector.project();
        List<Vertex3D> projectedVertices = projector.getProjectedVertices();

        System.out.println("projectedVertices = " + projectedVertices);

        Vertex3D vDesired1=new Vertex3D(0f, 0, 2.4142f);
        Vertex3D vDesired2=new Vertex3D(0f, 0, 2.4142f);

        Assert.assertTrue(projectedVertices.get(0).equals(vDesired1));
        Assert.assertTrue(projectedVertices.get(1).equals(vDesired2));
    }

    @Test
    public void transformToCameraThetaIsPiDiv4() {
        List<Vertex3D> vertexList = getVertexThetaIsPIDiv4();
        UVNCoordinateProjector projector=new UVNCoordinateProjector();
        ViewMediator mediator = getViewMediator(PIDIV4,R,ALPHA);
        mediator.setUVNVertices(vertexList);
        projector.setMediator(mediator);
        projector.project();
        List<Vertex3D> projectedVertices = projector.getProjectedVertices();

        System.out.println("projectedVertices = " + projectedVertices);

        Vertex3D vDesired1=new Vertex3D(0f, 0, 2.4142f);
        Vertex3D vDesired2=new Vertex3D(0.1837f, 0, 2.4142f);

        Assert.assertTrue(projectedVertices.get(0).equals(vDesired1));
        Assert.assertTrue(projectedVertices.get(1).equals(vDesired2));
    }


    private List<Vertex3D> getVertexThetaIsZero() {
        return Arrays.asList(
                new Vertex3D(0,0,10),
                new Vertex3D(0,0,9),
                new Vertex3D(0,1,9)
        );
    }

    private List<Vertex3D> getVertexThetaIsPIDiv4() {
        return Arrays.asList(
                new Vertex3D(0,0,10),
                new Vertex3D(0.7071f,0,9.2929f),
                new Vertex3D(0.7071f,1,9.2929f)
        );
    }

    private ViewMediator getViewMediator(float theta, float R, float alpha ) {
        ViewMediator mediator=new ViewMediator();
        mediator.setTheta(theta);
        mediator.setR(R);
        mediator.setAlpha(alpha);
        return mediator;
    }

}
