package viewservice.view_mediator;

public class MediatorMemberAbstract implements MediatorMemberInterface {
    protected ViewMediatorInterface mediator;

    @Override
    public void setMediator(ViewMediatorInterface mediator){
        this.mediator = mediator;
    }
}
