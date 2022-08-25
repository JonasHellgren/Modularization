package viewservice.view_mediator;

import domain.models.Dot2D;
import domain.models.Edge3D;
import domain.models.Line2D;
import domain.models.Vertex3D;
import domain.settings.Constants;
import lombok.Getter;
import lombok.Setter;
import viewservice.logic.LineGenerator;
import viewservice.logic.UVNCoordinateProjector;
import viewservice.logic.ViewPortTransformer;
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

@Setter
@Getter
public class ViewMediator implements ViewMediatorInterface {

    static final float R_DEFAULT=5;
    static final float THETA_DEFAULT=10;
    static final float ALPHA_DEFAULT=(float) Math.PI/2;
    static final float GAMMA_DEFAULT=(float) Math.PI/8;

    List<Vertex3D> worldVertices;
    List<Edge3D> edges;
    float R;        //distance to camera origo
    float theta;    //view angle
    float alpha;    //zoom factor
    float gamma;    //from above angle

    WorldToCameraTransformer transformer;
    UVNCoordinateProjector projector;
    ViewPortTransformer viewPortTransformer;
    LineGenerator lineGenerator;

    List<Vertex3D> UVNVertices;     //transformed vertices
    List<Vertex3D> projectedVertices;       //projected vertices
    List<Dot2D> dots;
    List<Line2D> lines;

    public ViewMediator() {
        this.worldVertices =new ArrayList<>();
        this.edges=new ArrayList<>();
        this.R = R_DEFAULT;
        this.theta = THETA_DEFAULT;
        this.alpha = ALPHA_DEFAULT;
        this.gamma=GAMMA_DEFAULT;
        newTransformer();
        newProjector();
        newViewPortTransformer();
        newLineGenerator();
    }

    @Override
    public void transformAndProject() {
        transform();
        project();
    }

    @Override
    public void transform() {
       // transformer.setWorldVertices(worldVertices);
        transformer.transform();
        UVNVertices=transformer.getUVNVertices();
    }

    @Override
    public void project() {
        projector.project();
        projectedVertices=projector.getProjectedVertices();
    }

    @Override
    public List<Dot2D> getDots() {
        List<Vertex3D> vertices=viewPortTransformer.divideProjectedVerticesWithAspectRatio();
        viewPortTransformer.transform(vertices);
        dots=viewPortTransformer.getViewPortDots();
        return dots;
    }

    @Override
    public List<Line2D> getLines() {
        lines=lineGenerator.getLines(dots);
        return lines;
    }

    @Override
    public void updateViewAngle(float newTheta) {
        this.theta=newTheta;
    }


    @Override
    public List<Vertex3D> getWorldVertices() {
        return worldVertices;
    }

    @Override
    public List<Vertex3D> getUVNVertices() {
        return UVNVertices;
    }

    @Override
    public List<Vertex3D> getProjectedVertices() {
        return projectedVertices;
    }


    private void newProjector() {
        this.projector = new UVNCoordinateProjector();
        projector.setMediator(this);
    }

    private void newTransformer() {
        this.transformer = new WorldToCameraTransformer();
        transformer.setMediator(this);
    }

    private void newViewPortTransformer() {
        this.viewPortTransformer=new ViewPortTransformer(Constants.W,Constants.H);
        this.viewPortTransformer.setMediator(this);
    }

    private void newLineGenerator() {
        this.lineGenerator=new LineGenerator();
        this.lineGenerator.setMediator(this);
    }


}
