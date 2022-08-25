package viewservice.logic;

import domain.models.Vertex3D;
import domain.utils.CommonMath;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import viewservice.view_mediator.MediatorMemberAbstract;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public  class UVNCoordinateProjector extends MediatorMemberAbstract {


    public  List<Vertex3D> project(@NonNull List<Vertex3D> UVNVertices) {

        List<Vertex3D> projectedVertices= new ArrayList<>();
        double alpha=mediator.getParValue("alpha");
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

        return projectedVertices;
    }

}
