package viewservice.api;

import domain.models.Dot2D;
import domain.models.Edge3D;
import domain.models.Line2D;
import domain.models.Vertex3D;

import java.util.List;

public interface ViewServiceInterface {
    void transformAndProject(List<Vertex3D> vertices);
    List<Dot2D> getDots();
    List<Line2D> getLines(List<Edge3D> edges);
    void updateViewAngle(float newTheta);
}
