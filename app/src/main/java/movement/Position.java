package movement;

import javafx.geometry.Pos;

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
    public Position sum(Position direction){
        return new Position(this.getX() + direction.getX() , this.getY() + direction.getY());
    }
    public Position sum(double speed){
        return new Position(this.getX() + speed , this.getY());
    }
    public Position subtract(double speed){
        return new Position(this.getX() - speed , this.getY());
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
