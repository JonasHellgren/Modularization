package viewservice.api;

import domain.models.Dot2D;
import domain.models.Edge3D;
import domain.models.Line2D;
import domain.models.Vertex3D;

import java.util.List;

public interface ViewServiceInterface {

    void insertVertices(List<Vertex3D> vertices);
    void insertEdges(List<Edge3D> edge3DS);
    void transformAndProject();
    List<Dot2D> getDots();
    List<Line2D> getLines();
    void setR(float newR);
    void setTheta(float newTheta);
    void setAlpha(float newAlpha);


}
