package viewservice.api;

import domain.models.Vertex3D;
import org.springframework.stereotype.Service;
import viewservice.logic.WorldToCameraTransformer;
import viewservice.view_mediator.ViewMediator;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViewServiceDummy {

    //ViewMediator viewMediator;
    WorldToCameraTransformer transformer;

    public ViewServiceDummy() {
        System.out.println("ViewServiceDummy constructor");
       // this.viewMediator = new ViewMediator();

        List<Vertex3D> vertices=new ArrayList<>();
        this.transformer=new WorldToCameraTransformer(vertices);  //todo exklude vertices, R, theta - later via mediator
       // transformer.setMediator(this);

    }
}
