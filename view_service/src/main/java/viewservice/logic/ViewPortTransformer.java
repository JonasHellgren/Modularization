package viewservice.logic;

import domain.models.Dot2D;
import domain.models.Matrix;
import domain.models.Vector3D;
import domain.models.Vertex3D;
import domain.settings.Constants;
import viewservice.view_mediator.MediatorMemberAbstract;

import java.util.ArrayList;
import java.util.List;

//https://lectureloops.com/window-to-view-port-transformation/
public class ViewPortTransformer extends MediatorMemberAbstract {

    private final double WINDOW_XMIN=-0.5;
    private final double WINDOW_XMAX=0.5;
    private final double WINDOW_YMIN=-0.5;
    private final double WINDOW_YMAX=0.5;


    private final double VIEWPORT_XMIN=0.0;
    private double VIEWPORT_XMAX;
    private final double VIEWPORT_YMIN=0;
    private double VIEWPORT_YMAX;


    List<Vertex3D> viewPortVertices;     //result vertices

    public ViewPortTransformer(double viewPortW, double viewPortH) {
        this.VIEWPORT_XMAX=viewPortW;
        this.VIEWPORT_YMAX=viewPortH;
        this.viewPortVertices = new ArrayList<>();
    }

    public List<Vertex3D> getViewPortVertices() {
        return viewPortVertices;
    }

    public Matrix createM() {


        Matrix T1= new Matrix(new double[][]{
                {1.0, 0.0, VIEWPORT_XMIN},
                {0.0, 1.0, VIEWPORT_YMIN},
                {0.0, 0.0, 1.0}});

        double sx=(VIEWPORT_XMAX-VIEWPORT_XMIN)/(WINDOW_XMAX-WINDOW_XMIN);
        double sy=(VIEWPORT_YMAX-VIEWPORT_YMIN)/(WINDOW_YMAX-WINDOW_YMIN);

        Matrix S= new Matrix(new double[][]{
                {sx, 0.0, 0.0},
                {0.0, sy, 0.0},
                {0.0, 0.0, 1.0}});


        Matrix T= new Matrix(new double[][]{
                {1.0, 0.0, -WINDOW_XMIN},
                {0.0, 1.0, -WINDOW_YMIN},
                {0.0, 0.0, 0.0}});


        return T1.mult(S).mult(T);

      //  return new Matrix(U.divWithScalar(U.norm()), V.divWithScalar(V.norm()), N.divWithScalar(N.norm()));
    }

    void transform() {
        List<Dot2D> vertexList=mediator.getDots();


        //todo call transform()
    }

    public void transform(List<Vertex3D> vertexList) {
        Matrix M = createM();

        for (Vertex3D v:vertexList) {
            Vertex3D resultV = M.mult(v);
            System.out.println("v = " + v);
            viewPortVertices.add(resultV);
        }
    }

    }
