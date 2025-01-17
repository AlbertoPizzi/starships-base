package config;

public class Config {
    //window config
    public static final double WINDOW_WIDTH = 800;
    public static final double WINDOW_HEIGHT = 800;
    //Ship config
    public static final double SHIP_WIDTH = 60.0;
    public static final double SHIP_HEIGHT = 60.0;
    public static final double HEALTH = 100.0;
    public static final double SHIP_MAX_SPEED = 5.0;
    public static final double SHIP_SPEED_INCREMENT = 0.6;
    public static final double SHIP_MIN_SPEED = 0.0;
    public static final double ROTATION = 15.0;
    public static final String SHIP_IMAGE_REF1 = "ship";
    public static final String SHIP_IMAGE_REF2 = "Xwing";
    public static final String SHIP_IMAGE_REF3 = "starship";

    public static final double SHIP1_ORIGIN = 100.0;
    public static final double SHIP1_INIT_DIRECTION = 0.0;
    public static final double SHIP2_ORIGIN = 700.0;
    public static final double SHIP2_INIT_DIRECTION = 0.0;
    //Bullet config
    public static final double BULLET_SPEED = 10.0;
    public static final double BULLET_HEIGHT = 0.5;
    public static final double BULLET_WIDTH = 0.5;
    public static final int BULLET_SIZE = 10;
    public static final int BULLET_DMG = 15;
    public static final int ROCKET_DMG = 25;
    public static final int ROCKET_SIZE = 20;
    public static final String BULLET_IMAGE = "shot";

    //Asteroid config
    public static final int MAX_ASTEROID_SIZE = 100;
    public static final int MIN_ASTEROID_SIZE = 20;
    public static final int ASTEROID_DMG = 10;
    public static final double ASTEROID_SPEED = 0.005;
    public static final double ASTEROID_SPAWN_PROB = 0.002;
    public static final String ASTEROID_IMAGE = "farquad";
}
