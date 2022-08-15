package ball_runner;

//import ball_service.api.BallService;
//import ball_service.api.BallService;
import ball_service.api.BallService;
import domain.models.Ball;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import java.util.logging.Logger;

//web browser: http://localhost:8080/result
//web browser: http://localhost:8080/mode
//web browser: http://localhost:8080/ballpos
//postman: http://localhost:8080/input

@RestController
public class BallController {

  //  private static final Logger logger = Logger.getLogger(BallController.class.getName());


    @Autowired
    BallService ballService;

    @GetMapping(value = "/ballposString")
    public String getBallPosString() {
        return ballService.getBall().toString();
    }

    @GetMapping(value = "/ballpos")
    public Ball getBallPos() {
        return ballService.getBall();
    }

}
