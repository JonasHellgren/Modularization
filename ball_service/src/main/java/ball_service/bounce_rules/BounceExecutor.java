package ball_service.bounce_rules;

//import lombok.NoArgsConstructor;
import domain.models.Ball;

//@NoArgsConstructor
abstract public class BounceExecutor {

    public BounceExecutor() {
    }

    abstract Boolean isApplicable(final Ball ball);
    abstract Ball execute(final Ball ball);
}
