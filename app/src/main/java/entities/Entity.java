package entities;

import movement.Position;

import java.util.Optional;

public interface Entity {
    public String getId();
    public EntityType getType();
    public EntityShape getShape();
    public int getDamage();
    public double getSpeed();
    public Optional<Entity> collide(Entity enemy);
    public double getSize();
    public String getOwnerId();
    public Position getPosition();
    public Entity update();
    public Position verify(Position pos);
    public Entity move(Boolean forward);
    public double getRotation();
}
