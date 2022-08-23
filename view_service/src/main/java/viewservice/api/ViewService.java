package viewservice.api;

import domain.models.Dot2D;
import domain.models.Edge3D;
import domain.models.Line2D;
import domain.models.Vertex3D;
import org.springframework.stereotype.Service;
import viewservice.view_mediator.ViewMediator;

import java.util.List;

@Service
public class ViewService implements ViewServiceInterface {

    ViewMediator viewMediator;

    public ViewService() {
        System.out.println("view constructor");
        this.viewMediator = new ViewMediator();  //todo static factory
    }


    @Override
    public void insertVertices(List<Vertex3D> vertices) {
        viewMediator.setVertices(vertices);

    }

    @Override
    public void insertEdges(List<Edge3D> edge3DS) {
        viewMediator.setEdges(edge3DS);
    }

    @Override
    public void transformAndProject() {
        viewMediator.transformAndProject();
    }

    @Override
    public List<Dot2D> getDots() {
        return viewMediator.getDots();
    }

    @Override
    public List<Line2D> getLines() {
        return viewMediator.getLines();
    }

    @Override
    public void setR(float newR) {
        viewMediator.setR(newR);
    }

    @Override
    public void setTheta(float newTheta) {
        viewMediator.setTheta(newTheta);
    }

    @Override
    public void setAlpha(float newAlpha) {
        viewMediator.setAlpha(newAlpha);
    }
}
