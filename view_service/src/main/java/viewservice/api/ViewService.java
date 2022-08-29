package viewservice.api;

import domain.models.*;
import org.springframework.stereotype.Service;
import viewservice.view_mediator.ViewMediator;
import viewservice.view_mediator.ViewMediatorInterface;

import java.util.List;

@Service
public class ViewService implements ViewServiceInterface {

    ViewMediatorInterface viewMediator;

    public ViewService() {
        this.viewMediator = ViewMediatorInterface.newViewMediator();
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
        return viewMediator.getDotsToPlot();
    }

    @Override
    public List<Line2D> getLines() {
        return viewMediator.getLinesToPlot();
    }


}
