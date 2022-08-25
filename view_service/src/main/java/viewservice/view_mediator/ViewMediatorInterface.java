package viewservice.view_mediator;

import domain.models.*;

import java.util.List;

public interface ViewMediatorInterface {
    void transformAndProject();
    List<Edge3D> getEdges();
    List<Dot2D> getViewPortDots();
    List<Line2D> getLines();
    float getParValue(String name);
    void changeParameterValue(Parameter par);
    List<Vertex3D> getWorldVertices();
    List<Vertex3D> getUVNVertices();
    List<Vertex3D> getProjectedVertices();

}
