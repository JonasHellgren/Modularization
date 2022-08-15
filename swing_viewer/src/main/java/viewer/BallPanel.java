package viewer;

import domain.models.Ball;
import domain.settings.Settings;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class BallPanel extends JPanel {
    //Can be seen as view class.

    private Ball ball;

    public BallPanel() {
        this.ball = Ball.newBallRandomPosAndSpeed();
    }
/*
    public void copyModelStates(GameModel gameModel) {
        racket.copyPos(gameModel.getRacket());
        tennisBall.copyPos(gameModel.getTennisBall());
    }
*/



    @Override
    public void paint(Graphics g) {
        super.paint(g);  //cleans the screen
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        /*
        for (Dot dot : dots) {
            g.setColor(dot.color);
            g.fillOval(dot.x, dot.y, dot.r, dot.r);
        }
*/
        g.setColor(ball.COLOR);
        g.fillOval(ball.x, Settings.H - ball.y, ball.radius, ball.radius);


    }
}
