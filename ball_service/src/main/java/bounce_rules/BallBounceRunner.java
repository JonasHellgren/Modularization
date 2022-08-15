package bounce_rules;

import models.Ball;

import java.util.ArrayList;
import java.util.List;

public class BallBounceRunner {

    List<BounceExecutor> executors;

    public BallBounceRunner(List<BounceExecutor> executors) {
        this.executors = executors;
    }

    public static BallBounceRunner newBallBounceRunner() {
        List<BounceExecutor> executors=new ArrayList<>();
        executors.add(new LeftOrRightWallExecutor());
        executors.add(new TopOrBottomWallExecutor());
        return new BallBounceRunner(executors);
    }

    public Ball apply(Ball ball)  {
        for (BounceExecutor executor: executors) {
            if (executor.isApplicable(ball)) {
                return executor.execute(ball);
            }
        }
        return ball; //when no executor was activated
    }

}
