package viewservice.logic;
import domain.models.Vertex3D;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public  class UVNCoordinateProjectorFixedDistance extends UVNCoordinateProjectorAbstract {


    float getN(Vertex3D UVNVertex) {
        return  mediator.getParValue("R");
    }

}
