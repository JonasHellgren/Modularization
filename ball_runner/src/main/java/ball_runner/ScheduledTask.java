package ball_runner;

import ball_service.api.BallService;
import domain.models.Ball;
import domain.settings.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    public static final long CALLING_TIME = Settings.DT_MILLIS;

    @Autowired
    BallService ballService;

    @Scheduled(initialDelay = CALLING_TIME, fixedRate = CALLING_TIME)
    public void calculate() throws InterruptedException {

        ballService.step();
        Ball ball=ballService.getBall();
        System.out.println("ball = " + ball);

    }
}
