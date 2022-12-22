package game;

import config.GameConfiguration;

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
}
