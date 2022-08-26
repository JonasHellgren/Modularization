package viewer;

import domain.models.*;
import domain.settings.Constants;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import viewservice.api.ViewService;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Log
public class ScheduledPanelPainting {
    public static final long CALLING_TIME = Constants.DT_MILLIS;
    public static final long INIT_DELAY = 1000L;

    public static final String VERTEX_URL = "http://localhost:8080/vertices";
    public static final String EDGE_URL = "http://localhost:8080/edges";
    public static final String PARAMETER_URL = "http://localhost:8080/parameters";
    public static final float THETA_SPEED = 0.01f;

    float theta;

    @Autowired
    View3DPanel panel;

    @Autowired
    ViewService viewService;

    private RestTemplate restTemplate;

    @PostConstruct
    public void setup() {
        restTemplate = new RestTemplate();
        theta=0;
    }

    @Scheduled(initialDelay = INIT_DELAY, fixedRate = CALLING_TIME)
    public void paint3d() throws InterruptedException {
        restReadParameter();
        setPanelFromRestEndPointData();
        panel.repaint();

        theta= theta+ THETA_SPEED;
        viewService.changeParameterValue(Parameter.newParameter("theta",theta));

    }

    private void setPanelFromRestEndPointData() {
        restReadVertices();
        restReadEdges();
        viewService.transformAndProject();
        panel.setVertices(viewService.getDots());
        panel.setEdges(viewService.getLines());
    }

    private void restReadVertices() {
        try {
            ResponseEntity<Vertex3D[]> response =
                    restTemplate.getForEntity(
                            VERTEX_URL,
                            Vertex3D[].class);

            Vertex3D[] vertices = response.getBody();
            assert vertices != null;
            viewService.insertVertices(Arrays.asList(vertices));

        } catch (RestClientException e) {
            log.warning("URL = " + VERTEX_URL + " does not exist");
            setDummyPanelData();
        } catch (Exception e) {
            log.warning("Unknown exception, class = "+e.getClass());
        }
    }


    private void restReadEdges() {
        try {
            ResponseEntity<Edge3D[]> response =
                    restTemplate.getForEntity(
                            EDGE_URL,
                            Edge3D[].class);

            Edge3D[] edges = response.getBody();
            assert edges != null;
            viewService.insertEdges(Arrays.asList(edges));

        } catch (RestClientException e) {
            log.warning("URL = " + EDGE_URL + " does not exist");
            setDummyPanelData();
        } catch (Exception e) {
            log.warning("Unknown exception, class = "+e.getClass());
        }
    }

    private void restReadParameter() {
        try {
            ResponseEntity<Parameter[]> response =
                    restTemplate.getForEntity(
                            PARAMETER_URL,
                            Parameter[].class);

            Parameter[] parameters = response.getBody();
            assert parameters != null;
            List<Parameter> params=Arrays.asList(parameters);
            List<Parameter> paramsExclTheta=params.stream().filter(p -> !p.name.equals("theta")).collect(Collectors.toList());
            viewService.changeParameterValues(paramsExclTheta);

        } catch (RestClientException e) {
            log.warning("URL = " + VERTEX_URL + " does not exist");
            setDummyPanelData();
        } catch (Exception e) {
            log.warning("Unknown exception, class = "+e.getClass());
        }
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
