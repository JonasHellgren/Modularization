package ball_service.api;

import domain.models.Ball;

public interface BallServiceInterface {

    //static factory method
    static BallServiceInterface build() {
        return BallService.newBallService();
    }

    void step();
    Ball getBall();

}
