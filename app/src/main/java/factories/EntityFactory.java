package factories;

import entities.*;
import movement.Position;

import java.util.ArrayList;
import java.util.List;

import static config.Config.*;

public class EntityFactory {

    public static List<Asteroid> generateAsteroids(int amountOfAsteroids){
        List<Asteroid> asteroids = new ArrayList<>();
        for (int i = 0; i < amountOfAsteroids ; i++) {
            asteroids.add(new Asteroid(EntityIdGenerator.generateId(EntityType.ASTEROID), randomAsteroidSize() , randomAsteroidSize()
                    , generateRandomPosition() , generateRandomPosition() , ASTEROID_SPEED , 180.0 , ASTEROID_DMG , true , randomAsteroidSize() , 100));
        }
        return asteroids;
    }

    public static Position generateRandomPosition() {
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
     public static double randomAsteroidSize(){
      return (Math.random()*(MAX_ASTEROID_SIZE - MIN_ASTEROID_SIZE) + MIN_ASTEROID_SIZE);
     }
}
