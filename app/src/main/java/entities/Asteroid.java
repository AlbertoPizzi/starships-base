package entities;

import movement.Position;

import java.util.Optional;

public class Asteroid extends Entity{

    private final int deathValue;
    public Asteroid(String id, double height, double width, Position position
            , Position direction, double speed, double rotationDegrees, double dmg, boolean isVisible, double currentHealth, int deathValue) {
        super(id, EntityType.ASTEROID, EntityShape.ELLIPTICAL, height, width, position, direction, speed, rotationDegrees, dmg, isVisible, currentHealth);
        this.deathValue = deathValue;
    }

    public Entity move(double transition) {
        Position newPos = new Position(
                getPosition().getX() - (getDirection().getX() * -Math.sin(Math.toRadians(getDirection().getY())) * transition * 50),
                getPosition().getY() - (getDirection().getX() * Math.cos(Math.toRadians(getDirection().getY())) * transition * 50)
        );
        return this.setPosition(newPos);
    }
    public Optional<Entity> collide(Entity enemy){
        return switch (enemy.getType()) {
            case ASTEROID -> Optional.of(this);
            case SHIP -> Optional.of(this.setCurrentHealth(0.0));
            case BULLET -> Optional.of(this.setCurrentHealth(getCurrentHealth() - enemy.getDmg()));
            default -> Optional.of(this);
        };
    }
    public int getDeathValue() {
        return deathValue;
    }
}
