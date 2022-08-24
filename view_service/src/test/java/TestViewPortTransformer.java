import domain.models.Vertex3D;
import org.junit.Assert;
import org.junit.Test;
import viewservice.logic.ViewPortTransformer;

import java.util.ArrayList;
import java.util.List;

public class TestViewPortTransformer {

    @Test
    public void transformationA() {

        ViewPortTransformer vpt=new ViewPortTransformer(1,1);

        List<Vertex3D> vertexList=new ArrayList<>();
        Vertex3D v=new Vertex3D(-0.5f,-0.5f,1);
        vertexList.add(v);

        vpt.transform(vertexList);

        System.out.println("vpt.getViewPortVertices() = " + vpt.getViewPortVertices());

    }

    @Test
    public void transformationB() {

        ViewPortTransformer vpt=new ViewPortTransformer(1,1);

        List<Vertex3D> vertexList=new ArrayList<>();
        Vertex3D v=new Vertex3D(0.5f,0.5f,1);
        vertexList.add(v);

        vpt.transform(vertexList);

        System.out.println("vpt.getViewPortVertices() = " + vpt.getViewPortVertices());

    }


}
