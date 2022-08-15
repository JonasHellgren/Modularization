package api;

import bounce_rules.BallBounceRunner;
import models.Ball;
import org.springframework.stereotype.Service;
import settings.Settings;

@Service
public class BallService implements BallServiceApi {
    
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
