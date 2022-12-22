package entities.collision;

import entities.Bullet;
import entities.Entity;

import java.util.Objects;
import java.util.Optional;

public class RocketCollision implements BulletCollision{
    @Override
    public Optional<Entity> collide(Bullet bullet, Entity entity) {
        if(Objects.equals(entity.getId(), bullet.getOwnerId())){
            return Optional.of(bullet);
        }
        else {
            return Optional.empty();
        }
    }
}
