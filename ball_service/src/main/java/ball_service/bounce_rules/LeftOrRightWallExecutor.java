package ball_service.bounce_rules;

//import lombok.extern.java.Log;
import domain.models.Ball;
import domain.settings.Settings;

//@Log
public class LeftOrRightWallExecutor extends BounceExecutor{
    @Override
    Boolean isApplicable(Ball ball) {
        return ( (ball.x  < 0) || (ball.x  > Settings.W - 2*ball.radius));
    }

    @Override
    Ball execute(Ball ball) {
  //      log.info("Ball collided with left or right wall");
        ball.spdX = -ball.spdX;
        return ball;
    }
}
