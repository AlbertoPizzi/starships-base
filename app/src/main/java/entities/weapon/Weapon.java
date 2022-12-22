package entities.weapon;

import entities.BulletType;
import entities.Entity;
import movement.Position;

import java.util.List;

public class Weapon {
    final double speed;
    final BulletType bulletType;
    final Shoot shooter;

    public Weapon(double speed, BulletType bulletType, Shoot shooter) {
        this.speed = speed;
        this.bulletType = bulletType;
        this.shooter = shooter;
    }
    public List<Entity> shoot(Position pos , String ownerId , double rotation){
        return shooter.shoot(bulletType , pos , speed , ownerId , rotation);
    }
}
//TODO: Implementar al Kotlin de una vez, y terminar el game state.