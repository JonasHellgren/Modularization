package viewer;

import domain.settings.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"viewer","viewservice/api","viewservice/logic"})
public class ViewApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ViewApplication.class)
                .headless(false)  //allow AWT classes to be instantiated
                .web(WebApplicationType.NONE)  //prevents the bundling of Tomcat or other Web components
                .run(args);
    }

    @Autowired
    private View3DFrame frame;

    @Autowired
    private View3DPanel panel;

    @Bean
    public CommandLineRunner runGame() {
        return (args) -> {

            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    frame.setVisible(true);
                    frame.setSize(Constants.W, Constants.H + Constants.MARGIN_Y);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            });

            frame.add(panel);

        };

    }


}
