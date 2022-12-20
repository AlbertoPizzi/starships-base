package entities;

import entities.collision.BulletCollision;

import java.util.Optional;

public class Bullet implements Entity{
    final double damage;
    final BulletType bulletType;
    final String id;
    final String owner_id;
    final EntityType entityType = EntityType.BULLET;
    final BulletCollision bulletCollision;
    final double size;

    public Bullet(BulletType bulletType, String id, String owner_id, BulletCollision bulletCollision, double size , double damage) {
        this.damage = damage;
        this.bulletType = bulletType;
        this.id = id;
        this.owner_id = owner_id;
        this.size = size;
        this.bulletCollision = bulletCollision;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public EntityType getType() {
        return entityType;
    }

    @Override
    public double getDamage() {
        return damage;
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
        return owner_id;
    }
}
