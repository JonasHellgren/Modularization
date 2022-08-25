package viewservice.view_mediator;

import domain.models.Dot2D;
import domain.models.Edge3D;
import domain.models.Line2D;
import domain.models.Vertex3D;

import java.util.List;

public interface ViewMediatorInterface {
    void transformAndProject();

   // void setVertices(List<Vertex3D> vertices);
   // void setEdges(List<Edge3D> edges);
    List<Edge3D> getEdges();
    List<Dot2D> getViewPortDots();
    List<Line2D> getLines();


    //float getTheta();
    float getAlpha();
    float getGamma();
    float getPar(String name);
    List<Vertex3D> getWorldVertices();
    List<Vertex3D> getUVNVertices();
    List<Vertex3D> getProjectedVertices();

}
