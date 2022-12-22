package factories;

import entities.*;
import entities.collision.BulletCollision;
import entities.oldFiles.BulletOld;
import entities.collision.PiercingCollision;
import entities.collision.RegularBulletCollision;
import movement.Position;
import static config.Config.*;

public class EntityFactory {
//    public static Bullet createBullet(BulletType bulletType, String ownerId, double rotation, Position position) {
//        return switch (bulletType) {
//            case NORMAL -> new Bullet(ownerId, EntityIdGenerator.generateId(EntityType.BULLET) , BULLET_DMG , EntityType.BULLET , bulletType, new RegularBulletCollision(), EntityShape.ELLIPTICAL
//                    , BULLET_SIZE, position , position)
//            case PIERCING -> new BulletOld(bulletType, EntityIdGenerator.generateId(EntityType.BULLET), ownerId, new PiercingCollision(), BULLET_SIZE, BULLET_DMG, position, position.getX(), position.getY())
//                    , position, Math.cos(Math.toRadians(rotation)) * BULLET_SPEED, Math.sin(Math.toRadians(rotation)) * BULLET_SPEED);
//            case ROCKET -> new BulletOld(bulletType, EntityIdGenerator.generateId(EntityType.BULLET), ownerId, new RegularBulletCollision(), ROCKET_SIZE, ROCKET_DMG, position, position.getX(), position.getY())
//                    , position, Math.cos(Math.toRadians(rotation)) * BULLET_SPEED / 4, Math.sin(Math.toRadians(rotation)) * BULLET_SPEED / 4);
//        };
//    }
    //TODO: Todo lo que es generator
}
