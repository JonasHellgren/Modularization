import domain.models.Dot2D;
import domain.models.Edge3D;
import domain.models.Parameter;
import domain.models.Vertex3D;
import domain.utils.CommonMath;
import org.junit.Assert;
import org.junit.Test;
import viewservice.view_mediator.ViewMediatorAbstract;
import viewservice.view_mediator.ViewMediatorProjection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestViewMediator {

    ViewMediatorAbstract vm;

    @Test
    public void testTransformAndProjectThetaIsZer0() {

        List<Vertex3D> projectedVertices = getProjectedVertices();

        System.out.println("projectedVertices = " + projectedVertices);

        Vertex3D vDesired1=new Vertex3D(0f, 0, 2.4142f);
        Vertex3D vDesired2=new Vertex3D(0f, 0, 2.4142f);

        Assert.assertTrue(projectedVertices.get(0).equals(vDesired1));
        Assert.assertTrue(projectedVertices.get(1).equals(vDesired2));

    }



    @Test public void getDots() {

        List<Vertex3D> projectedVertices = getProjectedVertices();
        System.out.println("projectedVertices = " + projectedVertices);
        List<Dot2D> dots=vm.getDotsToPlot();

        System.out.println("dots = " + dots);

        Assert.assertFalse(CommonMath.isZero(dots.get(2).getY()));

    }

    @Test
    public void testTransformAndProjectThetaIsZer0WithEmptyConstructorMediator() {

        List<Vertex3D> projectedVertices = getProjectedVertices();

        System.out.println("projectedVertices = " + projectedVertices);

        Vertex3D vDesired1=new Vertex3D(0f, 0, 2.4142f);
        Vertex3D vDesired2=new Vertex3D(0f, 0, 2.4142f);

        Assert.assertTrue(projectedVertices.get(0).equals(vDesired1));
        Assert.assertTrue(projectedVertices.get(1).equals(vDesired2));

    }


    private List<Vertex3D> getProjectedVertices() {
        float R = 10, theta = 0;
        float alpha = (float) Math.PI / 4;  //zoom factor

        List<Vertex3D> vertices = getVertex3DS();
        List<Edge3D> edges = new ArrayList<>();

        vm = new ViewMediatorProjection();
        vm.setWorldVertices(vertices);
        vm.setEdges(edges);

       // vm.setR(R);
       // vm.setTheta(theta);

        /*
        vm.changeParameterValue(new Parameter("theta",theta,""));
        vm.changeParameterValue(new Parameter("R",R,""));
        vm.setAlpha(alpha);
        vm.setGamma(0);  */

        vm.changeParameterValue(new Parameter("R",R,""));
        vm.changeParameterValue(new Parameter("theta",theta,""));
        vm.changeParameterValue(new Parameter("alpha",alpha,""));

        vm.changeParameterValue(new Parameter("gamma",0,""));


        vm.transformAndProject();
        return vm.getProjectedVertices();
    }

    private List<Vertex3D> getProjectedVerticesEmptyConstructorMediator() {


        List<Vertex3D> vertices = getVertex3DS();

        vm = new ViewMediatorProjection();
        vm.setWorldVertices(vertices);
        vm.transformAndProject();
        return vm.getProjectedVertices();
    }


    private List<Vertex3D> getVertex3DS() {
        return Arrays.asList(
                new Vertex3D(0, 0, 0),
                new Vertex3D(0, 0, 1),
                new Vertex3D(0, 1, 1)
        );
    }

}
