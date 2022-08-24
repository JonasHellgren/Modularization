package viewservice.logic;

import domain.models.Matrix;
import domain.models.Vector3D;
import domain.models.Vertex3D;
import lombok.Getter;
import viewservice.view_mediator.MediatorMemberAbstract;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WorldToCameraTransformer extends MediatorMemberAbstract {

    List<Vertex3D> UVNVertices;     //result vertices

    /*
    public void setWorldVertices(List<Vertex3D> worldVertices) {
        this.worldVertices = worldVertices;
    }

    */


    public WorldToCameraTransformer() {
        UVNVertices = new ArrayList<>();
    }


    public Matrix createM() {
        Vector3D V = new Vector3D(0, 1, 0);   //"up" vector
        Vector3D r = getrVector(mediator.getTheta(), mediator.getR());
        Vector3D N = r.reverse();
        Vector3D U = V.cross(N);
        return new Matrix(U.divWithScalar(U.norm()), V.divWithScalar(V.norm()), N.divWithScalar(N.norm()));
    }

    public void transform() {
        Matrix M= createM();
        Matrix Mtransp = M.transpose();
        UVNVertices.clear();
        List<Vertex3D> worldVertices=mediator.getWorldVertices();
        Vector3D r = getrVector(mediator.getTheta(), mediator.getR());
        for (Vertex3D vertexWorld : worldVertices) {
            Vertex3D tempVertex = vertexWorld.minus(r);
            Vertex3D vertex3DCameraCoordinates = tempVertex.mult(Mtransp);
            UVNVertices.add(vertex3DCameraCoordinates);
        }
    }

    public Vector3D getrVector(float theta, float R) {
        return new Vector3D(R * (float) Math.sin(theta), 0, R * (float) Math.cos(theta));
    }


}
