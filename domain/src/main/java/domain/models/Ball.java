package domain.models;


//import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import domain.settings.Settings;
import java.awt.*;
import java.io.Serializable;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor  //needed for deserialization
@ToString
public class Ball implements Serializable {

    public int x, y;
    public int spdX, spdY;
    public int radius;
    public static final Color COLOR=Color.BLUE;


    public static Ball newBallRandomPosAndSpeed() {
        int x=randInt(0,Settings.W);
        int y=randInt(0,Settings.H);
        int spdX=randInt(0,Settings.BALL_SPEED);
        int spdY=randInt(0,Settings.BALL_SPEED);
        return new Ball(x,y,spdX,spdY, Settings.BALL_RADIUS);
    }

    public static Ball copy(Ball ball) {
        return new Ball(ball.x,ball.y, ball.spdX, ball.spdY,ball.radius);
    }

    public static int randInt(int min, int max) {
        Random r=new Random();
        return r.nextInt((max - min) + 1) + min;
    }


}
