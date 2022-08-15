package ball_service.api;

import ball_service.bounce_rules.BallBounceRunner;
import domain.models.Ball;
import org.springframework.stereotype.Service;
import domain.settings.Settings;

@Service
public class BallService implements BallServiceInterface {
    
    Ball ball;
    BallBounceRunner ballBounceRunner;

    private BallService() {
        ball=Ball.newBallRandomPosAndSpeed();
        ballBounceRunner=BallBounceRunner.newBallBounceRunner();
    }

    public static BallService newBallService() {
        return new BallService();
    }

    @Deprecated
    public void stepOld() {
        //Updates ball states
        if (ball.x  < 0)
            ball.spdX = -ball.spdX;
        if (ball.x   > Settings.W - 2*ball.radius)
            ball.spdX = -ball.spdX;
        if (ball.y > Settings.H)
            ball.spdY = -ball.spdY;
        if (ball.y  < 2*ball.radius) {
            ball.spdY = -ball.spdY;
        }
        ball.x  = ball.x  + ball.spdX ;
        ball.y  = ball.y + ball.spdY;
    }


    //non clean if statements in stepOld replaced by step
    @Override
    public void step() {
        //Updates ball states
        ball=ballBounceRunner.apply(ball);
        ball.x  = ball.x  + ball.spdX ;
        ball.y  = ball.y + ball.spdY;
    }

    @Override
    public Ball getBall() {
        return Ball.copy(ball);
    }
}
