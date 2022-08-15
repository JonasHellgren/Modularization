package api;

public interface BallServiceApi {

    //static factory method
    static BallServiceApi build() {
        return BallService.newBallService();
    }

    void step();
    models.Ball getBall();

}
