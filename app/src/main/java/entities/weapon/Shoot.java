package entities.weapon;

import entities.BulletType;
import entities.Entity;
import movement.Position;

import java.util.List;

public interface Shoot {
    List<Entity> shoot(BulletType bulletType , Position position , double speed, String ownerId , double rotation);
}
