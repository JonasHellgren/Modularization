package viewer;

import domain.settings.Constants;
import lombok.Setter;
import models.Dot2D;
import models.Line2D;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Setter
public class View3DPanel extends JPanel {
    public static final int VERTEX_RADIUS = 5;
    public static final Color VERTEX_COLOR = Color.BLACK;
    public static final Color LINE_COLOR = Color.BLACK;


    private List<Dot2D> vertices;
    private List<Line2D> edges;


    public View3DPanel() {
        vertices=new ArrayList<>();
        edges=new ArrayList<>();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);  //cleans the screen
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        drawVertices(g);
        drawLines(g);
    }

    private void drawLines(Graphics g) {
        g.setColor(LINE_COLOR);
        for (Line2D line:edges) {
            g.drawLine(line.getX1(),Constants.H - line.getY1(),line.getX2(),Constants.H - line.getY2());
        }
    }

    private void drawVertices(Graphics g) {
        g.setColor(VERTEX_COLOR);
        for (Dot2D vertex:vertices) {
            g.drawOval(vertex.getX()-VERTEX_RADIUS, Constants.H - vertex.getY()-VERTEX_RADIUS, VERTEX_RADIUS*2,VERTEX_RADIUS*2);
        }
    }
}
