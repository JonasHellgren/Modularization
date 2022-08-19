package viewer;

import domain.settings.Constants;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class BallPanel extends JPanel {
    public static final int RADIUS = 10;
    //Can be seen as view class.

//    private Ball ball;

    public BallPanel() {
    //    this.ball = Ball.newBallRandomPosAndSpeed();
    }


    public void setBallPos(int x, int y) {
       // ball.x=x;
      //  ball.y=y;
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);  //cleans the screen
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.BLACK);
        g.fillOval(111, Constants.H - 111, RADIUS, RADIUS);

    }
}
