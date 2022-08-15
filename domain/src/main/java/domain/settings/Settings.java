package domain.settings;

public class Settings {

    public final static int W=1000;
    public final static int H=600;  //frame size
    public final static int MARGIN_Y=10;  //frame margin

    public final static int BALL_SPEED=10;
    public final static int DT_MILLIS =20;  //time step in millis, updating frequence=1/(DT/1000)
    public final static int BALL_RADIUS=10;

    public static final String BALL_POS_URL = "http://localhost:8080/ballpos";

}
