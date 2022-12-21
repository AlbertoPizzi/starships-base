package movement;

import entities.Entity;
import entities.Ship;


import static config.Config.*;

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

    public double getXOffset() {
        return xOffset;
    }

    public double getYOffset() {
        return yOffset;
    }

    @Override
    public double getX() {
        return Math.cos(Math.toRadians(rotation));
    }

    @Override
    public double getY() {
        return Math.sin(Math.toRadians(rotation));
    }

// distance between 2 points
    @Override
    public double calculateSpeed() {
        return Math.sqrt(Math.pow(xOffset, 2) + Math.pow(yOffset,2));
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

    @Override
    public Movable update() {
        Position pos = verify(new Position(position.getX() + xOffset , position.getY() + yOffset));
        return new ShipMover(ship, xOffset/1.005 , yOffset/1.005 , rotation , pos);
    }

    @Override
    public Position verify(Position pos) {
        if(pos.getX() < 0) return new Position(pos.getX() + WINDOW_WIDTH, pos.getY());
        if(pos.getX() > WINDOW_WIDTH) return new Position(pos.getX() - WINDOW_WIDTH , pos.getY());
        if(pos.getY() < 0) return new Position(pos.getX() , pos.getY() + WINDOW_HEIGHT);
        if(pos.getY() > 0) return new Position(pos.getX() , pos.getY() - WINDOW_HEIGHT);
        else {
            return pos;
        }
    }

    public double getAcceleration() {
        return acceleration;
    }
}
