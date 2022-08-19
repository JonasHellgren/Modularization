package environment_service.api;

import domain.models.Edge3D;
import domain.models.Vertex3D;

import java.util.List;

public interface EnvironmentServiceInterface {

    void insertVertices(List<Vertex3D> vertices);
    List<Vertex3D> getVertices();
    void insertEdges(List<Edge3D> edge3DS);
    List<Edge3D> getEdges();
    void rotateAroundY(float angle);

}
