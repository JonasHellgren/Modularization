package ball_service.api;

import domain.models.Ball;

public interface BallServiceApi {

    //static factory method
    static BallServiceApi build() {
        return BallService.newBallService();
    }

    void step();
    Ball getBall();

}
