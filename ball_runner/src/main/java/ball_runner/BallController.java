package ball_runner;

//import api.BallService;
//import api.BallService;
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


    //@Autowired
    //BallService ballService;

    @GetMapping(value = "/ballpos")
    public String getBallPos() {

        return "saasffffffffffffffff";
       // return ballService.getBall().toString();
    }

}
