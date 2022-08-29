package viewservice.view_mediator;

import viewservice.logic.UVNCoordinateProjectorVertexDependingDistance;

public class ViewMediatorProjection extends ViewMediatorAbstract {


    public ViewMediatorProjection() {
        super();
        this.projector = new UVNCoordinateProjectorVertexDependingDistance();
        projector.setMediator(this);
    }


}
