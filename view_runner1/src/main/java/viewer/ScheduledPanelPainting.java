package viewer;

import domain.models.Vertex3D;
import domain.settings.Constants;
import lombok.extern.java.Log;
import models.Dot2D;
import models.Line2D;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
@Log
public class ScheduledPanelPainting {


    public static final long CALLING_TIME = Constants.DT_MILLIS;
    public static final long INIT_DELAY = 1000L;

    public static final String VERTEX_URL = "http://localhost:8080/vertices";

    @Autowired
    View3DPanel panel;

    private RestTemplate restTemplate;

    @PostConstruct
    public void setup() {
        restTemplate = new RestTemplate();
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

        try {
            ResponseEntity<Vertex3D[]> response =
                    restTemplate.getForEntity(
                            VERTEX_URL,
                            Vertex3D[].class);

            Vertex3D[] vertices = response.getBody();
            assert vertices != null;
            System.out.println("vertex3DList = " + Arrays.asList(vertices));



        } catch (RestClientException e) {
            log.warning("URL = " + VERTEX_URL + " does not exist");
            setDummyPanelData();
        } catch (Exception e) {
            log.warning("Unknown exception, class = "+e.getClass());
        }

        // panel.setBallPos(ballFromUrl.x,ballFromUrl.y);
    }

    private void setDummyPanelData() {
        List<Dot2D> vertexList=Arrays.asList(
                new Dot2D(111,111),
                new Dot2D(222,222)
        );

        List<Line2D> edgeList=Arrays.asList(
                new Line2D(111,111,222,222)
        );

        panel.setVertices(vertexList);
        panel.setEdges(edgeList);



    }
}
