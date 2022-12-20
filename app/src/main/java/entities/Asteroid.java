package entities;

import java.util.Optional;

public class Asteroid implements Entity{

    final String id;
    final EntityType type = EntityType.ASTEROID;
    final double health;
    final double size;

    public Asteroid(String id, double health, double size) {
        this.id = id;
        this.health = health;
        this.size = size;
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
    public double getDamage() {
        return 0;
    }

    @Override
    public Optional<Entity> collide(Entity enemy) {
        return Optional.empty();
    }

    @Override
    public double getSize() {
        return size;
    }

    @Override
    public String getOwnerId() {
        return "";
    }
}
