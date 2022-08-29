import domain.models.Parameter;
import domain.models.Vertex3D;
import org.junit.Assert;
import org.junit.Test;
import viewservice.logic.UVNCoordinateProjectorVertexDependingDistance;
import viewservice.view_mediator.ViewMediatorAbstract;
import viewservice.view_mediator.ViewMediatorProjection;

import java.util.Arrays;
import java.util.List;

public class TestUVNCoordinateProjector {

    public static final int R = 10;
    static final float ALPHA=(float) Math.PI/4;
    public static final float PIDIV4 = (float) Math.PI / 4;

    @Test
    public void transformToCameraThetaIsZero() {
        List<Vertex3D> vertexList = getVertexThetaIsZero();
        UVNCoordinateProjectorVertexDependingDistance projector=new UVNCoordinateProjectorVertexDependingDistance();
        ViewMediatorAbstract mediator = getViewMediator(PIDIV4,R,ALPHA);
        mediator.setUVNVertices(vertexList);
        projector.setMediator(mediator);

        List<Vertex3D> projectedVertices=projector.project(mediator.getUVNVertices());
        //List<Vertex3D> projectedVertices = projector.getProjectedVertices();

        System.out.println("projectedVertices = " + projectedVertices);

        Vertex3D vDesired1=new Vertex3D(0f, 0, 2.4142f);
        Vertex3D vDesired2=new Vertex3D(0f, 0, 2.4142f);

        Assert.assertTrue(projectedVertices.get(0).equals(vDesired1));
        Assert.assertTrue(projectedVertices.get(1).equals(vDesired2));
    }

    @Test
    public void transformToCameraThetaIsPiDiv4() {
        List<Vertex3D> vertexList = getVertexThetaIsPIDiv4();
        UVNCoordinateProjectorVertexDependingDistance projector=new UVNCoordinateProjectorVertexDependingDistance();
        ViewMediatorAbstract mediator = getViewMediator(PIDIV4,R,ALPHA);
        mediator.setUVNVertices(vertexList);
        projector.setMediator(mediator);
        //projector.project();
        //List<Vertex3D> projectedVertices = projector.getProjectedVertices();

        List<Vertex3D> projectedVertices=projector.project(mediator.getUVNVertices());


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

    private ViewMediatorAbstract getViewMediator(float theta, float R, float alpha ) {
        ViewMediatorAbstract mediator=new ViewMediatorProjection();
        mediator.changeParameterValue(new Parameter("theta",theta,""));
        mediator.changeParameterValue(new Parameter("R",R,""));
        mediator.changeParameterValue(new Parameter("alpha",alpha,""));
        return mediator;
    }

}
