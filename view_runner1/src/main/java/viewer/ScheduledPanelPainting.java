package viewer;

import domain.models.Vertex3D;
import domain.settings.Constants;
import models.Vertex3DList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ScheduledPanelPainting {


    public static final long CALLING_TIME =  Constants.DT_MILLIS;
    public static final long INIT_DELAY = 1000L;

    public static final String VERTEX_URL = "http://localhost:8080/vertices";

    @Autowired
    BallPanel panel;

    private RestTemplate restTemplate;

    @PostConstruct
    public void setup() {
         restTemplate=new RestTemplate();
    }

    @Scheduled(initialDelay = INIT_DELAY, fixedRate = CALLING_TIME)
    public void calculate() throws InterruptedException {
        setPanelFromRestEndPointData();
        panel.repaint();
    }

    private void setPanelFromRestEndPointData() {
     //   Ball ballFromUrl = restTemplate.getForObject(Settings.BALL_POS_URL, Ball.class);

     //   Vertex3DList response=  restTemplate.getForObject(VERTEX_URL, Vertex3DList.class);
       // assert ballFromUrl != null;

        ResponseEntity<Vertex3D[]> response =
                restTemplate.getForEntity(
                        VERTEX_URL,
                        Vertex3D[].class);
        Vertex3D[] vertices = response.getBody();

        assert response != null;
        assert vertices != null;
        System.out.println("vertex3DList = " + Arrays.asList(vertices));

        // panel.setBallPos(ballFromUrl.x,ballFromUrl.y);
    }
}
