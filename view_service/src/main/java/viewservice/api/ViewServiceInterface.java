package viewservice.api;

import domain.models.*;

import java.util.List;

public interface ViewServiceInterface {

    void insertVertices(List<Vertex3D> vertices);
    void insertEdges(List<Edge3D> edge3DS);
  //  void insertParameters(List<Parameter> parameters);
    void transformAndProject();
    List<Dot2D> getDots();
    List<Line2D> getLines();
   // void setR(float newR);
   // void setTheta(float newTheta);
   // void setAlpha(float newAlpha);


}
