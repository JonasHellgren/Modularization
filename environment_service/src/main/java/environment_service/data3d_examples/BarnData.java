package environment_service.data3d_examples;

import domain.models.Edge3D;
import domain.models.Vertex3D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BarnData {

    public static List<Vertex3D> vertexList() {
        return new ArrayList<>(
                Arrays.asList(
                        new Vertex3D(0,0,0),
                        new Vertex3D(0,0,1),
                        new Vertex3D(0,1,1),
                        new Vertex3D(0,2,0.5f),
                        new Vertex3D(0,1,0),
                        new Vertex3D(1,0,0),
                        new Vertex3D(1,0,1),
                        new Vertex3D(1,1,1),
                        new Vertex3D(1,2,0.5f),
                        new Vertex3D(1,1,0)
                ));
    }


    public static List<Edge3D> edgeList() {
        return new ArrayList<>(
                Arrays.asList(
                        new Edge3D(1,2),
                        new Edge3D(2,3),
                        new Edge3D(3,4),
                        new Edge3D(4,5),
                        new Edge3D(5,1),
                        new Edge3D(6,7),
                        new Edge3D(7,8),
                        new Edge3D(8,9),
                        new Edge3D(9,10),
                        new Edge3D(10,6),
                        new Edge3D(1,6),
                        new Edge3D(2,7),
                        new Edge3D(3,8),
                        new Edge3D(4,9),
                        new Edge3D(5,10)
                ));
    }


}
