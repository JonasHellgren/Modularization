package viewer;

import domain.models.Vertex3D;
import domain.settings.Constants;
import lombok.extern.java.Log;
import domain.models.Dot2D;
import domain.models.Line2D;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import viewservice.api.ViewService;
import viewservice.api.ViewServiceDummy;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
@Log
public class ScheduledPanelPainting {


    public static final long CALLING_TIME = Constants.DT_MILLIS;
    public static final long INIT_DELAY = 1000L;

    public static final String VERTEX_URL = "http://localhost:8080/vertices";

    float theta;

    @Autowired
    View3DPanel panel;

    @Autowired
    ViewService viewService;
   // ViewServiceDummy viewServiceDummy;

    private RestTemplate restTemplate;

    @PostConstruct
    public void setup() {
        restTemplate = new RestTemplate();
        theta=0;
    }

    @Scheduled(initialDelay = INIT_DELAY, fixedRate = CALLING_TIME)
    public void calculate() throws InterruptedException {
        setPanelFromRestEndPointData();
        panel.repaint();

        theta= (float) (theta+0.1);
        viewService.setTheta(theta);

    }

    private void setPanelFromRestEndPointData() {

        try {
            ResponseEntity<Vertex3D[]> response =
                    restTemplate.getForEntity(
                            VERTEX_URL,
                            Vertex3D[].class);

            Vertex3D[] vertices = response.getBody();
            assert vertices != null;
            System.out.println("vertex3DList = " + Arrays.asList(vertices));

           viewService.insertVertices(Arrays.asList(vertices));


        } catch (RestClientException e) {
            log.warning("URL = " + VERTEX_URL + " does not exist");
            setDummyPanelData();
        } catch (Exception e) {
            log.warning("Unknown exception, class = "+e.getClass());
        }

        viewService.transformAndProject();
        panel.setVertices(viewService.getDots());

      //  System.out.println("viewService.getDots() = " + viewService.getDots());

        //setDummyPanelData();

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
