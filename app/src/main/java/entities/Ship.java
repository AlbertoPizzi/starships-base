package entities;

import config.Config;

import java.util.Optional;

public class Ship implements Entity{
    final String id;
    final EntityType type = EntityType.SHIP;
    final double health;
    final double size;
    final int power;
    final double dmg = Config.HEALTH;


    public Ship(String id, double health, double size, int power) {
        this.id = id;
        this.health = health;
        this.size = size;
        this.power = power;
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
        return dmg;
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
    public double getHealth() {
        return health;
    }

    public int getPower() {
        return power;
    }
}
