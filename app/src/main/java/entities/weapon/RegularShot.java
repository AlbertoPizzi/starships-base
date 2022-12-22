package entities.weapon;

import entities.BulletType;
import entities.Entity;
import factories.EntityFactory;
import movement.Position;

import java.util.ArrayList;
import java.util.List;

public class RegularShot implements Shoot{

    @Override
    public List<Entity> shoot(BulletType bulletType, Position position, double speed, String ownerId, double rotation) {
        List<Entity> bullets = new ArrayList<>();
//        bullets.add(EntityFactory.createB(bulletType , ownerId , rotation , position));
        return bullets;
    }
}
