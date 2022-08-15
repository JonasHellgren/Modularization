package viewer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.models.Ball;
import domain.settings.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"viewer"})
public class ViewApplication {

    public static final int TIME_BETWEEN_PAINTS = 100;

    public static void main(String[] args) {
        new SpringApplicationBuilder(ViewApplication.class)
                .headless(false)  //allow AWT classes to be instantiated
                .web(WebApplicationType.NONE)  //prevents the bundling of Tomcat or other Web components
                .run(args);
    }

    @Autowired
    private BallFrame frame;

    @Autowired
    private BallPanel panel;

    @Bean
    public CommandLineRunner runGame() {
        return (args) -> {

            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    frame.setVisible(true);
                    frame.setSize(Settings.W, Settings.H + Settings.MARGIN_Y);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            });

            frame.add(panel);


           // while (true) {
           //     panel.repaint();
          //      Thread.sleep(Settings.DT_MILLIS);
         //   }


        };

    }


}
