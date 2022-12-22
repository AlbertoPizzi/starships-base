package game;

import config.GameConfiguration;
import entities.BulletType;
import entities.Entity;
import entities.Ship;
import factories.EntityFactory;
import movement.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    GameState gameState;
    private boolean isPaused;
    private final GameConfiguration gameConfig;
    private boolean isFinished;
    private final Map<String , Integer> playerPoints;
    private final List<String> eliminated;
    private final EntityFactory entityFactory = new EntityFactory();

    public Game() {

        this.gameConfig = new GameConfiguration();
        this.isFinished = false;
        this.playerPoints = new HashMap<>();
        this.eliminated = new ArrayList<>();
    }
    public void start(boolean fromSaved){
        if(fromSaved) loadSavedGame();
        else loadNewGame();
        this.isPaused = false;
        loadPlayerPoints();
    }

    public List<Player> getPlayers(){
        if(gameState != null){
            gameState.getPlayers();
        }
        return null;
    }
    public void loadPlayerPoints(){
        for(Player player  : getPlayers()){
            playerPoints.put(player.getId(), player.getPoints());
        }
    }
    public void loadSavedGame(){
//TODO: Implementar esto tmb
    }
    public void loadNewGame(){
//TODO: Implementar esto tmb

    }
    public Game shoot(String shipId) {
        Ship ship = (Ship) gameState.getEntities().stream().filter(entity -> entity.getId().equals(shipId)).findFirst().get();
        Position shipPos = ship.getPosition();
        Position shipDir = ship.getDirection();
        Position bulletPos = new Position(shipPos.getX() + shipDir.getX() * ship.getSize() / 2, shipPos.getY() + shipDir.getY() * ship.getSize() / 2);
        gameState.getEntities().add(entityFactory.createBullet(BulletType.NORMAL, ship.getOwnerId(), ship.getRotation() , bulletPos));
        return this;
    }

}
