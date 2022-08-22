package viewservice.view_mediator;

import domain.models.Dot2D;
import domain.models.Edge3D;
import domain.models.Line2D;
import domain.models.Vertex3D;

import java.util.List;

public interface ViewMediatorInterface {
    void transformAndProject();
    void transform();
    void project();
   // void setVertices(List<Vertex3D> vertices);
   // void setEdges(List<Edge3D> edges);
    List<Dot2D> getDots();
    List<Line2D> getLines();
    void updateViewAngle(float newTheta);

}
