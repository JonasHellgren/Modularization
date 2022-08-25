import domain.models.Dot2D;
import domain.models.Vertex3D;
import domain.settings.Constants;
import org.junit.Assert;
import org.junit.Test;
import viewservice.logic.ViewPortTransformer;

import java.util.ArrayList;
import java.util.List;

public class TestViewPortTransformer {

    public static final int VIEW_PORT_W = Constants.W;
    public static final int VIEW_PORT_H = Constants.H;

    @Test
    public void transformationLowerLeft() {

        ViewPortTransformer vpt=new ViewPortTransformer(VIEW_PORT_W, VIEW_PORT_H);

        List<Vertex3D> vertexList=new ArrayList<>();
        Vertex3D v=new Vertex3D(-0.5f,-0.5f,1);
        vertexList.add(v);

        List<Dot2D> dots=vpt.transform(vertexList);
        Dot2D dot=dots.get(0);

        Dot2D dotDesired=new Dot2D(0,0);
        Assert.assertTrue(dot.equals(dotDesired));

    }

    @Test
    public void transformationUpperRight() {

        ViewPortTransformer vpt=new ViewPortTransformer(VIEW_PORT_W,VIEW_PORT_H);

        List<Vertex3D> vertexList=new ArrayList<>();
        Vertex3D v=new Vertex3D(0.5f,0.5f,1);
        vertexList.add(v);
//        vpt.transform(vertexList);
 //       Dot2D dot=vpt.getViewPortDots().get(0);
        List<Dot2D> dots=vpt.transform(vertexList);
        Dot2D dot=dots.get(0);



        Dot2D dotDesired=new Dot2D(VIEW_PORT_W, VIEW_PORT_H);
        Assert.assertTrue(dot.equals(dotDesired));
    }


    @Test
    public void transformationMiddle() {

        ViewPortTransformer vpt=new ViewPortTransformer(VIEW_PORT_W,VIEW_PORT_H);

        List<Vertex3D> vertexList=new ArrayList<>();
        Vertex3D v=new Vertex3D(0.0f,0.0f,1);
        vertexList.add(v);

        List<Dot2D> dots=vpt.transform(vertexList);
        Dot2D dot=dots.get(0);

        Dot2D dotDesired=new Dot2D(VIEW_PORT_W/2, VIEW_PORT_H/2);
        Assert.assertTrue(dot.equals(dotDesired));
    }


}
