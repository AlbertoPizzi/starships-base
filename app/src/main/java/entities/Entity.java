package entities;

import java.util.Optional;

public interface Entity {
    public String getId();
    public EntityType getType();
    public double getDamage();
    public Optional<Entity> collide(Entity enemy);
    public double getSize();
    public String getOwnerId();
}
