package entities;


import static config.Config.SHIP_MAX_SPEED;
import static config.Config.SHIP_SPEED_INCREMENT;

import config.Config;
import movement.Position;

import java.util.Optional;

public class Ship extends Entity{
    private final String playerId;
    private final int shotsFired;
    public Ship(String id, double height, double width, Position position, Position direction
            , double speed, double rotationDegrees, double dmg, boolean isVisible, double currentHealth, String playerId, int shotsFired) {
        super(id, EntityType.SHIP, EntityShape.TRIANGULAR, height, width, position, direction, speed, rotationDegrees, dmg, isVisible, currentHealth);
        this.playerId = playerId;
        this.shotsFired = shotsFired;
    }

    public Entity move(double transition){
        Position newPos = new Position(
                getPosition().getX() - (getDirection().getX() * -Math.sin(Math.toRadians(getDirection().getY())) * transition * 50),
                getPosition().getY() - (getDirection().getX() * Math.cos(Math.toRadians(getDirection().getY())) * transition  * 50)
        );
        return this.setPosition(newPos);
    }
    public Entity accelerate(){
        if(getDirection().getX() <= SHIP_MAX_SPEED){
            return setDirectionSpeed(getDirection().sum(SHIP_SPEED_INCREMENT));
        }
        return this;
    }
    public Entity decelerate(){
        if(getDirection().getX() <= SHIP_MAX_SPEED){
            return this.setDirectionSpeed(getDirection().subtract(SHIP_SPEED_INCREMENT));
        }
        return this;
    }
    public Optional<Entity> collide(Entity enemy){
        return switch(enemy.getType()){
            case ASTEROID -> Optional.of(this.setCurrentHealth( getCurrentHealth() - Config.ASTEROID_DMG * enemy.getDmg()));
            case BULLET -> Optional.of(this);
            case SHIP -> Optional.of(this);
            default -> Optional.of(this);
        };
    }

    public Entity rotate(double rotation){
        return this.setRotationDegrees(rotation);
    }
    public String getPlayerId() {
        return playerId;
    }

    public int getShotsFired() {
        return shotsFired;
    }

}
