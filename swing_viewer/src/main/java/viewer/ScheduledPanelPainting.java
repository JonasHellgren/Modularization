package viewer;

import domain.models.Ball;
import domain.settings.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import javax.annotation.PostConstruct;

@Component
public class ScheduledPanelPainting {

    public static final long CALLING_TIME =  Settings.DT_MILLIS;
    public static final long INIT_DELAY = 1000L;

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
        Ball ballFromUrl = restTemplate.getForObject(Settings.BALL_POS_URL, Ball.class);
        assert ballFromUrl != null;
        panel.setBallPos(ballFromUrl.x,ballFromUrl.y);
    }
}
