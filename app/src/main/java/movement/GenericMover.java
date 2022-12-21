package movement;

import entities.Entity;

public class GenericMover implements Movable{
    final Entity entity;
    final Position position;
    final double xOffSet;
    final double yOffSet;

    public GenericMover(Entity entity, Position position, double xOffSet, double yOffSet) {
        this.entity = entity;
        this.position = position;
        this.xOffSet = xOffSet;
        this.yOffSet = yOffSet;
    }


    @Override
    public double getX() {
        return xOffSet;
    }

    @Override
    public double getY() {
        return yOffSet;
    }
    public GenericMover update(){
        return new GenericMover(entity , new Position(position.getX() + xOffSet, position.getY() + yOffSet ) , xOffSet , yOffSet);
    }

    @Override
    public Position verify(Position pos) {
        return null;
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
        return entity.getId();
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    @Override
    public double getRotation() {
        return Math.toDegrees(Math.atan(yOffSet/xOffSet));
    }
}
