package entities;

import factories.EntityIdGenerator;
import movement.Position;

import java.util.Optional;
import static config.Config.*;

public class Bullet extends Entity{
    private final String shipId;
    private final BulletType bulletType;
    public Bullet(String id, double height, double width, Position position, Position direction, double speed, double rotationDegrees, double dmg, boolean isVisible, double currentHealth, String shipId, BulletType bulletType) {
        super(id, EntityType.BULLET, EntityShape.ELLIPTICAL, height, width, position, direction, speed, rotationDegrees, dmg, isVisible, currentHealth);
        this.shipId = shipId;
        this.bulletType = bulletType;
    }

    public Entity move(double transition){
        Position newPos = new Position(
                getPosition().getX() - (getDirection().getX() * -Math.sin(Math.toRadians(getDirection().getY())) * transition * 50),
                getPosition().getY() - (getDirection().getX() * Math.cos(Math.toRadians(getDirection().getY())) * transition  * 50)
        );
        return this.setPosition(newPos);
    }
    public Optional<Entity> collide(Entity enemy){
        return switch (enemy.getType()) {
            case ASTEROID -> Optional.of(this.setCurrentHealth(0.0));
            case SHIP -> Optional.of(this);
            case BULLET -> Optional.of(this);
            default -> Optional.of(this);
        };
    }
    public Bullet shoot(Ship ship){
        Bullet bullet =  setDirection(ship.getDirection());
        bullet = bullet.setVisible(true);
        bullet = bullet.setPosition(new Position(ship.getPosition().getX()+20 , ship.getPosition().getY()));
        return bullet;
    }
    public Bullet setPosition(Position position) {
        return new Bullet(getId(),getHeight(),getWidth(),position, getDirection(), getSpeed() , getRotationDegrees(), getDmg(), isVisible(), getCurrentHealth(), shipId, bulletType);
    }

    public Bullet setDirection(Position direction) {
        return new Bullet(getId(),getHeight(),getWidth(),getPosition(), direction, getSpeed() , getRotationDegrees(), getDmg(), isVisible(), getCurrentHealth(), shipId, bulletType);
    }

    public Bullet setSpeed(double speed) {
        return new Bullet(getId(),getHeight(),getWidth(),getPosition(), getDirection(), speed , getRotationDegrees(), getDmg(), isVisible(), getCurrentHealth(), shipId, bulletType);
    }

    public Bullet setRotationDegrees(double rotationDegrees) {
        return new Bullet(getId(),getHeight(),getWidth(),getPosition(), getDirection(), getSpeed() , rotationDegrees, getDmg(), isVisible(), getCurrentHealth(), shipId, bulletType);
    }

    public Bullet setVisible(boolean isVisible) {
        return new Bullet(getId(),getHeight(),getWidth(),getPosition(), getDirection(), getSpeed() , getRotationDegrees(), getDmg(), isVisible, getCurrentHealth(), shipId, bulletType);
    }
    public String getShipId() {
        return shipId;
    }
}
