package bounce_rules;

//import lombok.extern.java.Log;
import models.Ball;
import settings.Settings;

//@Log
public class TopOrBottomWallExecutor extends BounceExecutor{
    @Override
    Boolean isApplicable(Ball ball) {
        return ( (ball.y > Settings.H) || (ball.y  < 2*ball.radius));
    }

    @Override
    Ball execute(Ball ball) {
  //      log.info("Ball collided with top or bottom wall");
        ball.spdY = -ball.spdY;
        return ball;
    }
}
