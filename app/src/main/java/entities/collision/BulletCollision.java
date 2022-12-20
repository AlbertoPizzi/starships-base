package entities.collision;

import entities.Bullet;
import entities.Entity;

import java.util.Optional;

public interface BulletCollision {

    Optional<Entity> collide(Bullet bullet , Entity entity);
}
