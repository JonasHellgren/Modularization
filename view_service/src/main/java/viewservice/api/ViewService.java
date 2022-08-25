package viewservice.api;

import domain.models.*;
import org.springframework.stereotype.Service;
import viewservice.view_mediator.ViewMediator;

import java.util.List;
import java.util.Optional;

@Service
public class ViewService implements ViewServiceInterface {

    ViewMediator viewMediator;

    public ViewService() {
        System.out.println("view constructor");
        this.viewMediator = new ViewMediator();  //todo static factory
    }

    @Override
    public void insertVertices(List<Vertex3D> vertices) {
        viewMediator.setWorldVertices(vertices);
    }

    @Override
    public void insertEdges(List<Edge3D> edge3DS) {
        viewMediator.setEdges(edge3DS);
    }

    @Override
    public void changeParameterValues(List<Parameter> pars) {
        for (Parameter p:pars) {
            changeParameterValue(p);
        }
    }

    @Override
    public void changeParameterValue(Parameter par) {
        viewMediator.changeParameterValue(par);
    }

    @Override
    public void transformAndProject() {
        viewMediator.transformAndProject();
    }

    @Override
    public List<Dot2D> getDots() {
        return viewMediator.getViewPortDots();
    }

    @Override
    public List<Line2D> getLines() {
        return viewMediator.getLines();
    }

}
