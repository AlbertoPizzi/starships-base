package factories;

import entities.*;
import movement.Position;

import java.util.ArrayList;
import java.util.List;

import static config.Config.*;

public class EntityFactory {
    public  Bullet createBullet(BulletType bulletType, String ownerId, double rotation, Position position) {
//        return switch (bulletType) {
//            case NORMAL -> new Bullet(ownerId, EntityIdGenerator.generateId(EntityType.BULLET) , BULLET_DMG , EntityType.BULLET , bulletType, new RegularBulletCollision(), EntityShape.ELLIPTICAL
//                    , BULLET_SIZE, position , position);
//            case ROCKET -> new Bullet(ownerId, EntityIdGenerator.generateId(EntityType.BULLET), ROCKET_DMG,EntityType.BULLET , bulletType, new RegularBulletCollision(), EntityShape.ELLIPTICAL
//                    , ROCKET_SIZE , position , position);
//        };
        return null;
    }
    public List<Asteroid> asteroidGenerator(int amountOfAsteroids){
//        List<Asteroid> asteroids = new ArrayList<>();
//        for (int i = 0; i < amountOfAsteroids ; i++) {
//            asteroids.add(new Asteroid(EntityIdGenerator.generateId(EntityType.ASTEROID), EntityType.ASTEROID , EntityShape.ELLIPTICAL
//                    ,  randomAsteroidSize() , generateRandomPosition() , generateRandomPosition(), ASTEROID_SPEED , randomAsteroidSize(), true ));
//        }
//        return asteroids;
        return null;
    }

    public Position generateRandomPosition() {
         double random = Math.random();
         if (random < 0.25) {
             return new Position(0, Math.random() * WINDOW_HEIGHT);
         } else if (random < 0.5) {
             return new Position(WINDOW_WIDTH, Math.random() * WINDOW_HEIGHT);
         } else if (random < 0.75) {
             return new Position(Math.random() * WINDOW_WIDTH, 0);
         } else {
             return new Position(Math.random() * WINDOW_WIDTH, WINDOW_HEIGHT);
         }
     }
     public double randomAsteroidSize(){
      return (Math.random()*(MAX_ASTEROID_SIZE - MIN_ASTEROID_SIZE) + MIN_ASTEROID_SIZE);
     }
    //TODO: Todo lo que es generator
}
