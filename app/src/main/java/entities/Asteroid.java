package entities;

import config.Config;
import movement.Position;

import java.util.Optional;

public class Asteroid implements Entity{
    final String id;
    final EntityType type;
    final EntityShape shape;
    final double dmg;
    final double size;
    final Position position;
    final Position direction;
    final double speed;
    final double rotation;
    final boolean clockwise;
    public Asteroid(String id, EntityType type, EntityShape shape, double size, Position position, Position direction, double speed , double rotation , boolean clockwise ) {
        this.id = id;
        this.type = type;
        this.shape = shape;
        this.dmg = size * Config.ASTEROID_DMG;
        this.size = size;
        this.position = position;
        this.direction = direction;
        this.speed = speed;
        this.rotation = rotation;
        this.clockwise = clockwise;
    }

    @Override
    public String getId() {
        return null;
    }

    public Position getDirection(){
        return direction;
    }
    @Override
    public EntityType getType() {
        return type;
    }

    @Override
    public EntityShape getShape() {
        return shape;
    }

    @Override
    public int getDamage() {
        return (int)dmg;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public Optional<Entity> collide(Entity enemy) {
        if(enemy.getType().equals(EntityType.BULLET)){
            if(size <= Config.MIN_ASTEROID_SIZE){
                return Optional.empty();
            }
            else{
                return Optional.of(new Asteroid(getId(),getType(),getShape(),getSize()- enemy.getDamage(), getPosition(),getDirection(),getSpeed(), getRotation(), getClockwise()));
            }
        }else {
            return Optional.of(this);
        }
    }

    @Override
    public double getSize() {
        return size;
    }

    @Override
    public String getOwnerId() {
        return id;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Entity update() {
        return new Asteroid(getId() , getType() ,getShape() ,getSize() , new Position(position.getX()+ speed , position.getY()+ speed)
                ,getDirection(),getSpeed() - 5 , getRotation() , getClockwise()) ;
    }

    @Override
    public Position verify(Position pos) {
        return null;
    }


    @Override
    public Entity move(Boolean forward) {
        double newX = getPosition().getX() + 0.7 * Math.sin(Math.PI * 2 * getDirection().getX() / 360);
        double newY = getPosition().getY() + 0.7 * Math.cos(Math.PI * 2 * getDirection().getY() / 360);
        double newRotation;
        if (clockwise) {
            newRotation = getRotation() + 2;
        } else {
            newRotation = getRotation() - 2;
        }
        return new Asteroid(getId(),getType(),getShape(),getSize(),new Position(newX , newY) , getDirection(), getSpeed() , newRotation , getClockwise());
    }
    public boolean getClockwise(){
        return clockwise;
    }

    @Override
    public double getRotation() {
        return rotation;
    }
}
