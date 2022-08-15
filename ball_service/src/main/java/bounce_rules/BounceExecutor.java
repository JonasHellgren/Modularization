package bounce_rules;

//import lombok.NoArgsConstructor;
import models.Ball;

//@NoArgsConstructor
abstract public class BounceExecutor {

    public BounceExecutor() {
    }

    abstract Boolean isApplicable(final Ball ball);
    abstract Ball execute(final Ball ball);
}
