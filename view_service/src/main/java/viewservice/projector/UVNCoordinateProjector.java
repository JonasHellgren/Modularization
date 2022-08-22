package viewservice.projector;

import domain.models.Vertex3D;
import domain.utils.CommonMath;

import java.util.ArrayList;
import java.util.List;

public class UVNCoordinateProjector {

    List<Vertex3D> UVNVertices;             //input vertices
    List<Vertex3D> projectedVertices;       //result vertices
    float alpha;

    public UVNCoordinateProjector(List<Vertex3D> UVNVertices, float alpha) {
        this.UVNVertices = UVNVertices;
        this.projectedVertices=new ArrayList<>();
        this.alpha=alpha;
    }

    public List<Vertex3D> getProjectedVertices() {
        return projectedVertices;
    }

    public void project() {

        projectedVertices.clear();
        float tanHalfAlpha= (float) Math.tan(alpha/2);
        assert !CommonMath.isZero(tanHalfAlpha);
        float d=CommonMath.safeDiv(1,tanHalfAlpha);

        for (Vertex3D UVNVertex:UVNVertices)  {
            float u=UVNVertex.getData().getX();
            float v=UVNVertex.getData().getY();
            float n=UVNVertex.getData().getZ();

            Vertex3D vertex3DProj=new Vertex3D(
                    CommonMath.safeDiv(u,n*tanHalfAlpha),
                    CommonMath.safeDiv(v,n*tanHalfAlpha),
                    d);

            projectedVertices.add(vertex3DProj);
        }


    }

}
