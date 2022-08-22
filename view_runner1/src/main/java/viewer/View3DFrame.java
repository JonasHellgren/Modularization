package viewer;

import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class View3DFrame extends JFrame {

    public View3DFrame() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ball viewer");
    }

}
