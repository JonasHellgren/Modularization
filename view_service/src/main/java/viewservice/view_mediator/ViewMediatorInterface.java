package viewservice.view_mediator;

import domain.models.*;

import java.util.List;

public interface ViewMediatorInterface {
    void transformAndProject();
    List<Edge3D> getEdges();
    List<Dot2D> getDotsToPlot();
    List<Line2D> getLinesToPlot();
    List<Vertex3D> getWorldVertices();
    List<Vertex3D> getUVNVertices();
    List<Vertex3D> getProjectedVertices();
    float getParValue(String name);
    void changeParameterValue(Parameter par);

}
