package viewer;

import domain.models.Ball;
import domain.settings.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@Component
public class ScheduledTask {

    public static final long CALLING_TIME =  Settings.DT_MILLIS;
    public static final long INIT_DELAY = 1000L;

    public static final String URL = Settings.BALL_POS_URL;

    @Autowired
    BallPanel panel;

    @Scheduled(initialDelay = INIT_DELAY, fixedRate = CALLING_TIME)
    public void calculate() throws InterruptedException {
        RestTemplate rt=new RestTemplate();
        Ball ballFromUrl = rt.getForObject(URL, Ball.class);
        assert ballFromUrl != null;
        panel.setBallPos(ballFromUrl.x,ballFromUrl.y);
        panel.repaint();
    }
}
