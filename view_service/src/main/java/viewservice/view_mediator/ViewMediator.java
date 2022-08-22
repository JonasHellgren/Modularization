package viewservice.view_mediator;

import domain.models.Dot2D;
import domain.models.Edge3D;
import domain.models.Line2D;
import domain.models.Vertex3D;
import domain.settings.Constants;
import lombok.NonNull;
import viewservice.logic.UVNCoordinateProjector;
import viewservice.logic.WorldToCameraTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Thanks to the mediator pattern fields do not need to be transferred via method parameters.
 * Following fields will have access to the mediator: chain and costFunction.
 * Chain requires access to designVariable and constraintCheckResults.
 * costFunction requires access to designVariable and costResult.
 * <p>
 * The chain field implements the chain of responsibility pattern. A constraint will be "caught" by the relevant
 * receiver in the chain.
 */

public class ViewMediator implements ViewMediatorInterface {

    List<Vertex3D> vertices;
    List<Edge3D> edges;
    float R, theta, alpha;

    WorldToCameraTransformer transformer;
    UVNCoordinateProjector projector;

    List<Vertex3D> UVNVertices;     //transformed vertices
    List<Vertex3D> projectedVertices;       //projected vertices


    public ViewMediator(@NonNull List<Vertex3D> vertices,
                        @NonNull List<Edge3D> edges,
                        float R, float theta, float alpha) {
        this.vertices = vertices;
        this.edges = edges;
        this.R = R;
        this.theta = theta;
        this.alpha = alpha;

        this.transformer=new WorldToCameraTransformer(vertices,R,theta);  //todo exklude vertices, R, theta - later via mediator
        transformer.setMediator(this);

        this.projector=new UVNCoordinateProjector(alpha);  //todo alpha - later via mediator
        projector.setMediator(this);

    }

    public List<Vertex3D> getProjectedVertices() {
        return projectedVertices;
    }

    @Override
    public void transformAndProject() {
        transform();
        project();
    }

    @Override
    public void transform() {
        transformer.transform();
        UVNVertices=transformer.getUVNVertices();
    }

    @Override
    public void project() {
        projector.setUVNVertices(UVNVertices);  //todo - remove access via mediator
        projector.project();
        projectedVertices=projector.getProjectedVertices();
    }

    @Override
    public List<Dot2D> getDots() {

        List<Dot2D> dots=new ArrayList<>();
        for (Vertex3D vertex3D:projectedVertices) {
            Dot2D dot=new Dot2D((int) vertex3D.getData().getX()* Constants.W,(int) vertex3D.getData().getY()*Constants.H);
            dots.add(dot);
        }

        return dots;
    }

    @Override
    public List<Line2D> getLines() {
        return null;
    }

    @Override
    public void updateViewAngle(float newTheta) {
        this.theta=newTheta;

    }
}
