package factories;

public class PositionFactory {
    public static int currentPosition = 100;

    public static double generatePosition(){
        currentPosition += 40;
        return currentPosition;
    }
}
