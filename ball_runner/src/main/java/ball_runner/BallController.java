package ball_runner;

import ball_service.api.BallService;
import domain.models.Ball;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//web browser: http://localhost:8080/ballpos

@RestController
public class BallController {

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
