package viewservice.logic;

import domain.models.Matrix;
import domain.models.Vector3D;
import domain.models.Vertex3D;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import viewservice.view_mediator.MediatorMemberAbstract;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class WorldToCameraTransformer extends MediatorMemberAbstract {

    public Matrix createM() {
        Vector3D V = new Vector3D(0, 1, 0);   //"up" vector
        Vector3D r = getVectorBetweenCameraAndWorldOrigo(mediator.getParValue("theta"),mediator.getParValue("gamma"), mediator.getParValue("R"));
        Vector3D N = r.reverse();
        Vector3D U = V.cross(N);
        return new Matrix(U.divWithScalar(U.norm()), V.divWithScalar(V.norm()), N.divWithScalar(N.norm()));
    }

    public List<Vertex3D>  transform(@NonNull List<Vertex3D> worldVertices ) {
        List<Vertex3D> UVNVertices= new ArrayList<>();
        Matrix M= createM();
        Matrix Mtransp = M.transpose();
        Vector3D r = getVectorBetweenCameraAndWorldOrigo(mediator.getParValue("theta"),mediator.getParValue("gamma"), mediator.getParValue("R"));
        for (Vertex3D vertexWorld : worldVertices) {
            Vertex3D tempVertex = vertexWorld.minus(r);
            Vertex3D vertex3DCameraCoordinates = tempVertex.mult(Mtransp);
            UVNVertices.add(vertex3DCameraCoordinates);
        }
        return UVNVertices;
    }

    public Vector3D getVectorBetweenCameraAndWorldOrigo(float theta, float gamma, float R) {
        return new Vector3D(R * (float) Math.sin(theta), (float) (R*Math.sin(gamma)), R * (float) Math.cos(theta));
    }

}
