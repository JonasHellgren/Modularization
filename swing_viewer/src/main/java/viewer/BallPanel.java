package viewer;

import domain.models.Ball;
import domain.settings.Settings;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

@Component
public class BallPanel extends JPanel {
    //Can be seen as view class.

    private Ball ball;

    public BallPanel() {
        this.ball = Ball.newBallRandomPosAndSpeed();
    }


    public void setBallPos(int x, int y) {
        ball.x=x;
        ball.y=y;
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);  //cleans the screen
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(ball.COLOR);
        g.fillOval(ball.x, Settings.H - ball.y, ball.radius, ball.radius);

    }
}
