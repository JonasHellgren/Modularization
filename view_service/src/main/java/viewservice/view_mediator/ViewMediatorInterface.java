package viewservice.view_mediator;
import domain.models.*;
import java.util.List;

public interface ViewMediatorInterface {
    void transformAndProject();
    List<Edge3D> getEdges();
    float getGamma();
    float getPar(String name);
    List<Dot2D> getDotsToPlot();
    List<Line2D> getLinesToPlot();
    List<Vertex3D> getUVNVertices();
    List<Vertex3D> getProjectedVertices();

    void setWorldVertices(List<Vertex3D> vertices);
    void setEdges(List<Edge3D> edge3DS);

    float getParValue(String name);
    void changeParameterValue(Parameter par);

    static ViewMediatorAbstract newViewMediatorProjection() {
        return new ViewMediatorProjection();
    }

    static ViewMediatorAbstract newViewMediatorNoProjection() {
        return new ViewMediatorNoProjection();
    }


}
