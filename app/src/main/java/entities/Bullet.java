package entities;

import config.Config;
import entities.collision.BulletCollision;
import movement.Position;

import java.util.Optional;

public class Bullet implements Entity{

    final String bulletID;
    final int dmg;
    final EntityType type;
    final BulletType bulletType;
    final EntityShape shape;
    final double size;
    final Position initPos;
    final String ownerId;
    final Position direction;
    final double speed;
    final BulletCollision bulletCollision;

    public Bullet( String ownerId, String bulletID, int dmg, EntityType type, BulletType bulletType, BulletCollision bulletCollision, EntityShape shape, double size, Position initPos, Position direction) {

        this.bulletID = bulletID;
        this.dmg = dmg;
        this.type = type;
        this.bulletType = bulletType;
        this.shape = shape;
        this.size = size;
        this.initPos = initPos;
        this.ownerId = ownerId;
        this.direction = direction;
        this.speed = Config.BULLET_SPEED;
        this.bulletCollision = bulletCollision;
    }



    public BulletType getBulletType() {
        return bulletType;
    }

    public Position getInitPos() {
        return initPos;
    }

    public Position getDirection() {
        return direction;
    }

    @Override
    public String getId() {
        return bulletID;
    }

    @Override
    public EntityType getType() {
        return type;
    }

    @Override
    public EntityShape getShape() {
        return shape;
    }

    @Override
    public int getDamage() {
        return dmg;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public Optional<Entity> collide(Entity enemy) {
      if(bulletType == BulletType.NORMAL){
          bulletCollision.collide(this , enemy);
      }
      return Optional.empty();
    }

    @Override
    public double getSize() {
        return size;
    }

    @Override
    public String getOwnerId() {
        return ownerId;
    }

    @Override
    public Position getPosition() {
        return initPos;
    }

    @Override
    public Entity update() {
        return move(true);
    }

    @Override
    public Position verify(Position pos) {
        return null;
    }
    public BulletCollision getBulletCollision(){
        return bulletCollision;
    }

    @Override
    public Entity move(Boolean forward) {
        double newX = getPosition().getX() - 4 * Math.sin(Math.PI * 2 * getDirection().getX() / 360);
        double newY = getPosition().getY() + 4 * Math.cos(Math.PI * 2 * getDirection().getY() / 360);
        return new Bullet(getOwnerId(),getId(),getDamage(),getType(),getBulletType(), getBulletCollision(), getShape(),getSize(), new Position(newX , newY)
                , getDirection());
    }

    @Override
    public double getRotation() {
        return 0;
    }
}
