package movement;

public class Position {
    final double x;
    final double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    @Override
    public boolean equals(Object obj) {
        if( obj instanceof Position){
            return ((Position) obj).getY() == this.getY() &&
                    ((Position) obj).getX() == this.getX();
        }
        return false;
    }
}
