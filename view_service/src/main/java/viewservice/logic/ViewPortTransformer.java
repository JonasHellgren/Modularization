package viewservice.logic;

import domain.models.Dot2D;
import domain.models.Matrix;
import domain.models.Vertex3D;
import domain.utils.CommonMath;
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


    List<Dot2D> viewPortDots;     //result dots

    public ViewPortTransformer(double viewPortW, double viewPortH) {
        this.VIEWPORT_XMAX=viewPortW;
        this.VIEWPORT_YMAX=viewPortH;
        this.viewPortDots = new ArrayList<>();
    }

    public List<Dot2D> getViewPortDots() {
        return viewPortDots;
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
    }

 //why? see https://www.youtube.com/watch?v=md3jFANT3UM&list=PLgcKMlJueAM47pYH8pz_J2R9OM5jwW5Z0&index=5
    public List<Vertex3D> divideProjectedVerticesWithAspectRatio() {

        float aspectRatio=  (float) (VIEWPORT_XMAX-VIEWPORT_XMIN)/
                            (float) (VIEWPORT_YMAX-VIEWPORT_YMIN);
        assert !CommonMath.isZero(aspectRatio);

        System.out.println("aspectRatio = " + aspectRatio);

        List<Vertex3D> vertex3DList=new ArrayList<>();
        for (Vertex3D v:mediator.getProjectedVertices()) {
            float newX=v.getData().getX()/aspectRatio;
            v.getData().setX(newX);

            Vertex3D vNew=new Vertex3D(newX,v.getData().getY(),v.getData().getZ());
            vertex3DList.add(vNew);
        }
        return vertex3DList;

    }

    public void transform(List<Vertex3D> vertexList) {
        Matrix M = createM();
        viewPortDots.clear();
        for (Vertex3D v:vertexList) {
            Vertex3D resultV = M.mult(v);
            Dot2D dot=new Dot2D((int) resultV.getData().getX(),(int) resultV.getData().getY());
            viewPortDots.add(dot);
        }
    }

    }
