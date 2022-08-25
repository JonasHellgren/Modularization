package viewservice.view_mediator;

import domain.models.*;
import domain.settings.Constants;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import viewservice.logic.LineGenerator;
import viewservice.logic.UVNCoordinateProjector;
import viewservice.logic.ViewPortTransformer;
import viewservice.logic.WorldToCameraTransformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Thanks to the mediator pattern fields do not need to be transferred via method parameters.
 * The working horses WorldToCameraTransformer..LineGenerator do all have access to parameters, for ex R
 */

@Setter
@Getter
@Log
public class ViewMediator implements ViewMediatorInterface {

    //given data
    static final float R_DEFAULT=5;
    static final float THETA_DEFAULT=10;
    static final float ALPHA_DEFAULT=(float) Math.PI/2;
    static final float GAMMA_DEFAULT=(float) Math.PI/8;
    static final float DEFAULT_PAR_VALUE=1;


    List<Vertex3D> worldVertices;  //3d data
    List<Edge3D> edges;  //3d data
    List<Parameter> parameters;
    float R;        //distance to camera origo
    float theta;    //view angle
    float alpha;    //zoom factor
    float gamma;    //from above angle

    //work horses
    WorldToCameraTransformer transformer;
    UVNCoordinateProjector projector;
    ViewPortTransformer viewPortTransformer;
    LineGenerator lineGenerator;

    //results
    List<Vertex3D> UVNVertices;         //transformed vertices
    List<Vertex3D> projectedVertices;   //projected vertices
    List<Dot2D> viewPortDots;           //the dots to show in panel
    List<Line2D> lines;                 //the lines to show in panel

    public ViewMediator() {
        this.worldVertices =new ArrayList<>();
        this.edges=new ArrayList<>();
        this.R = R_DEFAULT;
        this.theta = THETA_DEFAULT;
        this.alpha = ALPHA_DEFAULT;
        this.gamma=GAMMA_DEFAULT;
        this.parameters=new ArrayList<>();
        parameters.add(new Parameter("R",R_DEFAULT,""));
        parameters.add(new Parameter("theta",THETA_DEFAULT,""));
        parameters.add(new Parameter("alpha",ALPHA_DEFAULT,""));
        parameters.add(new Parameter("gamma",GAMMA_DEFAULT,""));

        newTransformer();
        newProjector();
        newViewPortTransformer();
        newLineGenerator();
    }

    @Override
    public void transformAndProject() {
        UVNVertices=transformer.transform(worldVertices);
        projectedVertices=projector.project(UVNVertices);
    }

    public List<Dot2D> getViewPortDots() {
        List<Vertex3D> vertices = viewPortTransformer.divideProjectedVerticesWithAspectRatio(projectedVertices);
        viewPortDots = viewPortTransformer.transform(vertices);
        return viewPortDots;
    }

    @Override
    public List<Line2D> getLines() {
        lines=lineGenerator.getLines(viewPortDots);
        return lines;
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

    public void changeParameterValue(Parameter par)  {
        Optional<Parameter> parToChange=parameters.stream().filter(p -> p.name.equals(par.getName())).findAny();

        if (parToChange.isPresent()) {
            parToChange.get().value=par.value;
        } else
        {
            log.warning("Parameter not present, name = "+par.name);
        }

    }

   // @Override
    public float getPar(String name) {
        Optional<Parameter> par=parameters.stream().filter(p -> p.name.equals(name)).findAny();
        if (par.isEmpty()) {
            log.warning("Parameter not defined, name = "+name);
        }
        return par.map(parameter -> parameter.value).orElse(DEFAULT_PAR_VALUE);
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
