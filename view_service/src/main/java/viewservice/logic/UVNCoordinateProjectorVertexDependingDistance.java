package viewservice.logic;
import domain.models.Vertex3D;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public  class UVNCoordinateProjectorVertexDependingDistance extends UVNCoordinateProjectorAbstract {

    float getN(Vertex3D UVNVertex) {
        return UVNVertex.getData().getZ();
    }

}
