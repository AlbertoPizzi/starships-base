package entities;

import config.Config;

import movement.Position;

import java.util.Optional;

public class Ship implements Entity{
    final String id;
    final EntityType type;
    final EntityShape shape;
    final int health;
    final double size;
    final Position initPos;
    final double speed;
    final String ownerId;
    final double rotation;
    final Position direction;

    public Ship(String id, EntityType type, EntityShape shape, String ownerId, int health, double size, Position initPos, Position direction, double speed, double rotation) {
        this.id = id;
        this.type = type;
        this.shape = shape;
        this.health = health;
        this.size = size;
        this.initPos = initPos;
        this.speed = speed;
        this.ownerId = ownerId;
        this.rotation = rotation;
        this.direction = direction;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public EntityType getType() {
        return type;
    }

    @Override
    public EntityShape getShape() {
        return shape ;
    }

    @Override
    public int getDamage() {
        return health;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public Optional<Entity> collide(Entity enemy) {
        if(enemy.getType().equals(EntityType.ASTEROID)) {
            if(enemy.getPosition().equals(initPos) && this.getDamage() - enemy.getDamage() > 0){
                Optional.of(new Ship(getId(), getType() , getShape() , getOwnerId(), getDamage() - enemy.getDamage() , getSize() , getPosition(), getDirection(),getSpeed() , getRotation()));
            }
        }if(enemy.getType().equals(EntityType.BULLET) || enemy.getType().equals(EntityType.SHIP)){
            return Optional.of(this);
        }else{
            return Optional.empty();
        }
    }

    @Override
    public double getSize() {
        return size;
    }

    @Override
    public String getOwnerId() {
        return ownerId;
    }

    @Override
    public Position getPosition() {
        return initPos;
    }

    @Override
    public Entity update() {
        if (speed > 0){
            double newX =  (getPosition().getX() - 3.5 * Math.sin(Math.PI * 2 * getDirection().getX() / 360));
            double newY =  (getPosition().getY() + 3.5 * Math.cos(Math.PI * 2 * getDirection().getY() / 360));
            return new Ship(getId(), getType() , getShape() , getOwnerId() , getDamage() , getSize()
                    , new Position(newX , newY) , getDirection() , getSpeed() - 5 , getRotation());
        }else return new Ship(getId(),getType(),getShape(),getOwnerId(),getDamage(),getSize(),getPosition(),getDirection(),getSpeed(),getRotation());

    }

    @Override
    public Position verify(Position pos) {
        return null;
    }

    @Override
    public Entity move(Boolean forward) {
        if(forward){
            return upSpeed();
        }
        else return downSpeed();
    }
    public Ship upSpeed(){
        if(speed < 1000){
            return new Ship(getId() , getType() , getShape() , getOwnerId() , getDamage() , getSize() , getPosition() ,getDirection() , getSpeed() + Config.SHIP_SPEED , getRotation());
        }
        else return this;
    }
    public Ship downSpeed(){
        if(speed > 0){
            return new Ship(getId() , getType() , getShape() , getOwnerId() , getDamage() , getSize() , getPosition() , getDirection(), getSpeed() - Config.SHIP_SPEED , getRotation());
        }
        else return this;
    }
    public Ship rotate(double rotation){
        return new Ship(getId() , getType() , getShape() , getOwnerId() , getDamage() , getSize() , getPosition() ,getDirection() , getSpeed() , getRotation() + rotation);
    }


    @Override
    public double getRotation() {
        return rotation;
    }

    public Position getDirection() {
        return direction;
    }
}
