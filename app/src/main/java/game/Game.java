package game;

import config.GameConfiguration;
import entities.*;
import factories.EntityFactory;
import movement.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {

    private List<Player> players;
    private List<Asteroid> asteroids;
    private List<Bullet> bullets;
    private List<Entity> entities;
    private GameConfiguration configuration;
    private boolean isPaused;
    private boolean isOver;

    public Game(){
        configuration = new GameConfiguration();
    }
    public void newGame(){
        createPlayers();
        createAsteroids();
        createBullets(5);
        fillEntities();
    }
    private void fillEntities(){
        entities = new ArrayList<>();
        for (Player player: players) {
            entities.add(player.getShip());
        }
        entities.addAll(asteroids);
        entities.addAll(bullets);
    }
    public void start(){
        newGame();
        this.isPaused = false;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public void reset(){
        newGame();
    }

    public void update(){
        if (!isPaused){
            if (entities != null) {
                EntityFactory.generateAsteroids(asteroids.size());
                List<Entity> entitiesAux = new ArrayList<>();
                List<Bullet> bulletsAux = new ArrayList<>();
                List<Asteroid> asteroidsAux = new ArrayList<>();
                for (int i = 0; i < entities.size(); i++) {
                    Entity entity = entities.get(i);
                    if (entity.getType() == EntityType.SHIP) {
                        Ship spaceship = (Ship) entity;
                        Ship newSpaceship = spaceship.update();
                        entitiesAux.add(newSpaceship);
                        Player owner = getPlayerByShip(spaceship);
                        owner.setShip(newSpaceship);
                    } else if (entity.getType() == EntityType.BULLET){
                        Bullet bullet = (Bullet) entity;
                        Bullet newBullet = bullet.update();
                        entitiesAux.add(newBullet);
                        bulletsAux.add(newBullet);
                    } else if (entity.getType() == EntityType.ASTEROID){
                        Asteroid asteroid = (Asteroid) entity;
                        Asteroid newAsteroid = asteroid.update();
                        entitiesAux.add(newAsteroid);
                        asteroidsAux.add(newAsteroid);
                    }
                }
                entities = entitiesAux;
                bullets = bulletsAux;
                asteroids = asteroidsAux;
            }
        }
    }

    public void moveShip(int spaceshipIndex, Position direction) {
        if (spaceshipIndex < entities.size() && entities.get(spaceshipIndex).getType() == EntityType.SHIP && !isPaused) {
            Ship spaceship = (Ship) entities.get(spaceshipIndex);
            Player owner = getPlayerByShip(spaceship);
            Ship newSpaceship = (Ship) spaceship.move(direction);
            entities.set(entities.indexOf(spaceship), newSpaceship);
            owner.setShip(newSpaceship);
        }
    }
    public void rotateShip(int spaceshipIndex, double rotation){
        if (spaceshipIndex < entities.size() && entities.get(spaceshipIndex).getType() == EntityType.SHIP && !isPaused){
            Ship spaceship = (Ship) entities.get(spaceshipIndex);
            Player owner = getPlayerByShip(spaceship);
            Ship newSpaceship = (Ship) spaceship.rotate(rotation);
            entities.set(entities.indexOf(spaceship), newSpaceship);
            owner.setShip(newSpaceship);
        }
    }
        public Player getPlayerByShip(Ship ship){
            String playerId = ship.getPlayerId();
            for (Player player: players) {
                if(player.getId().equals(playerId)){
                    return player;
                }
            }
            return null;
        }
    public void shoot(int spaceshipIndex){
        if (spaceshipIndex < entities.size() && entities.get(spaceshipIndex).getType() == EntityType.SHIP){
            Ship spaceship = (Ship) entities.get(spaceshipIndex);
            for (Entity entity : entities){
                if (entity.getType() == EntityType.BULLET){
                    Bullet bullet = (Bullet) entity;
                    if (!bullet.isVisible() && Objects.equals(bullet.getShipId(), spaceship.getId())) {
                        Bullet newBullet = bullet.shoot(spaceship);
                        entities.set(entities.indexOf(bullet), newBullet);
                        bullets.set(bullets.indexOf(bullet), newBullet);
                        break;
                    }
                }
            }
        }
    }
    public void createPlayers(){
        players = new ArrayList<>();
        int amount = configuration.getNbrOfPlayers();
        for (int i = 1; i <= amount; i++) {
            Ship spaceship;
            if (i == 1) {
                spaceship = new Ship("spaceship-" + i, 70, 70, new Position(330, 350), new Position(0, 1), 0, 180, 20, true, 100, "player-" + i, 0 );
            } else {
                spaceship = new Ship("spaceship-" + i, 70, 70, new Position(410, 350), new Position(0, 1), 0, 180, 20, true, 100, "player-" + i, 0 );
            }
            players.add(new Player("player-" + i, 0, configuration.getLivesPerPlayer(), spaceship, true));
        }
    }
    public void createBullets(int amount){
        bullets = new ArrayList<>();
        for (int i = 1; i <= amount; i++) {
            Ship ship = putInShip(amount, configuration.getNbrOfPlayers(), i);
            bullets.add(new Bullet("bullet-" + i, 40, 20, new Position(-100, -100), new Position(0, 0), 7, 0, 35, false,1 ,ship.getId(), BulletType.NORMAL));
            i++;
            bullets.add(new Bullet("bullet-" + i, 50, 25, new Position(-100, -100), new Position(0, 0), 7, 0, 40, false,1 ,ship.getId(), BulletType.NORMAL));
            i++;
            bullets.add(new Bullet("bullet-" + i, 60, 30, new Position(-100, -100), new Position(0, 0), 7, 0, 45, false,1 ,ship.getId(), BulletType.NORMAL));
        }
    }
    private Ship putInShip(int amountOfBullets, int amountOfShips, int i){
        List<Ship> spaceships = new ArrayList<>();
        for (Player player: players) {
            spaceships.add(player.getShip());
        }
        int aux = amountOfBullets/amountOfShips;
        for (int j = 0; j < amountOfShips; j++) {
            if (i < aux) {
                return spaceships.get(j);
            }
            aux *= 2;
        }
        return spaceships.get(amountOfShips-1);
    }
    public void handleCollision(String entity, String enemy){
        Entity entity1 = null;
        Entity entity2 = null;
        for (Entity aux: entities) {
            if(aux.getId().equals(entity)) entity1 = aux;
            if(aux.getId().equals(enemy)) entity2 = aux;
        }
        if(entity1 != null && entity2 != null && entity1.isVisible() && entity2.isVisible()) {
            if (entity1.getType().equals(EntityType.ASTEROID)) {
                Asteroid aux = (Asteroid) entity1;
                aux.collide(entity2);
            }
            if (entity1.getType().equals(EntityType.BULLET)) {
                Bullet aux = (Bullet) entity1;
                aux.collide(entity2);
            }
            if (entity1.getType().equals(EntityType.SHIP)) {
                Ship aux = (Ship) entity1;
                aux.collide(entity2);
            }
        }
    }

    public void createAsteroids(){
        asteroids = new ArrayList<>();
        int amount = configuration.getAmountOfAsteroids();
        int amountPerSize = amount / 3;
        for (int i = 1; i <= amountPerSize; i++) {
            asteroids.add(new Asteroid("asteroid-" + i, 50, 50, new Position(-100, -100), new Position(1, -1), 0, 180, 60, false, 50, 50));
            i++;
            asteroids.add(new Asteroid("asteroid-" + i, 70, 70, new Position(-100, -100), new Position(1, -1), 0, 180, 80, false, 75, 75));
            i++;
            asteroids.add(new Asteroid("asteroid-" + i, 90, 90, new Position(-100, -100), new Position(1, -1), 0, 180, 100, false, 100, 100));
        }
    }
    public void updateObjects(Entity newEntity, Entity entity){
        int indexEntities = entities.indexOf(entity);
        entities.set(indexEntities, newEntity);
    }

    public void updateBullets(Bullet newBullet, Bullet bullet){
        int indexBullets = bullets.indexOf(bullet);
        bullets.set(indexBullets, newBullet);
    }

    public void updateAsteroids(Asteroid newAsteroid, Asteroid asteroid){
        int indexAsteroids = asteroids.indexOf(asteroid);
        asteroids.set(indexAsteroids, newAsteroid);
    }

    public void updateSpaceships(Ship newSpaceship, Ship spaceship){
        Player owner = getPlayerByShip(spaceship);
        owner.setShip(newSpaceship);
    }
    public List<Player> getPlayers() {
        return players;
    }

    public List<Asteroid> getAsteroids() {
        return asteroids;
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public GameConfiguration getConfiguration() {
        return configuration;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public boolean isOver() {
        return isOver;
    }
}
