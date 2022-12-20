package movement;

import entities.Entity;
import entities.Ship;

public class ShipMover implements Movable{
    final Ship ship;
    final double acceleration = 0.5;
    final double xOffset;
    final double yOffset;
    final double rotation;
    final Position position;

    public ShipMover(Ship ship, double xOffset, double yOffset, double rotation, Position position) {
        this.ship = ship;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.rotation = rotation;
        this.position = position;
    }

    @Override
    public double getX() {
        return xOffset;
    }

    @Override
    public double getY() {
        return yOffset;
    }

    @Override
    public double calculateSpeed() {
        return 0;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public String getId() {
        return ship.getId();
    }

    @Override
    public Entity getEntity() {
        return ship;
    }

    @Override
    public double getRotation() {
        return rotation;
    }

    public double getAcceleration() {
        return acceleration;
    }
}
