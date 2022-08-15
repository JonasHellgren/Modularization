package ball_runner;

//import api.BallService;
//import models.Ball;
//import api.BallService;
//import models.Ball;
//import models.Ball;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    public static final long CALLING_TIME = 500L;
    public static final long CALC_TIME = 2000L;

    @Autowired
    //BallService ballService;

    @Scheduled(initialDelay = CALLING_TIME, fixedRate = CALLING_TIME)
    public void calculate() throws InterruptedException {

  //      ballService.step();
    //    Ball ball=ballService.getBall();
        //System.out.println("ball = " + ball);

    }
}
