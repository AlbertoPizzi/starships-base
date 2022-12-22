package entities.collision;

import entities.Bullet;
import entities.oldFiles.BulletOld;
import entities.Entity;

import java.util.Objects;
import java.util.Optional;

public class RegularBulletCollision implements BulletCollision{
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
