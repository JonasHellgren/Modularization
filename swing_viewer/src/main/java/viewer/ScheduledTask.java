package viewer;

//import ball_service.api.BallService;
//import models.Ball;
//import ball_service.api.BallService;
//import models.Ball;
//import models.Ball;
import domain.models.Ball;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledTask {

    public static final long CALLING_TIME = 500L;
    public static final long INIT_DELAY = 2000L;

    public static final String URL = "http://localhost:8080/ballpos";

  //  @Autowired
  //  BallService ballService;

    @Scheduled(initialDelay = INIT_DELAY, fixedRate = CALLING_TIME)
    public void calculate() throws InterruptedException {


        RestTemplate rt=new RestTemplate();
            Ball ball = rt.getForObject(URL, Ball.class);
            System.out.println("ball = " + ball);

    }
}
