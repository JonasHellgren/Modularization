package viewer;

import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class BallFrame extends JFrame {

    public BallFrame() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ball viewer");
    }

}
