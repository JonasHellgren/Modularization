package viewservice.view_mediator;

import viewservice.logic.UVNCoordinateProjectorFixedDistance;

public class ViewMediatorNoProjection extends ViewMediatorAbstract {

    public ViewMediatorNoProjection() {
        super();
        this.projector = new UVNCoordinateProjectorFixedDistance();
        projector.setMediator(this);
    }

}
