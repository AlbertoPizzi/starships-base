package config;

import javafx.scene.input.KeyCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameConfiguration {
    private final int nbrOfPlayers;
    private final int livesPerPlayer;
    private final int amountOfAsteroids;
    private final Map<String, KeyCode> keyMap;
    private final Map<String , String> images;

    public GameConfiguration(){
        List<String> lines = getLines("app/src/main/java/config/GameConfigFile");
        Map<String , String> optionsMap = generateMap(lines);

        nbrOfPlayers = Integer.parseInt(optionsMap.get("nbrOfPlayers"));
        livesPerPlayer = Integer.parseInt(optionsMap.get("livesPerPlayer"));
        amountOfAsteroids = Integer.parseInt(optionsMap.get("amountOfAsteroids"));
        keyMap = getKeyMap(optionsMap.get("Keymap"));
        images = getImages(optionsMap.get("images"));
    }

    private Map<String, String> generateMap(List<String> lines){
        Map<String, String> map = new HashMap<>();
        for (String line : lines){
            String[] split = line.split(":");
            map.put(split[0], split[1]);
        }
        return map;
    }
    private Map<String, String> getImages(String images){
        Map<String , String> map = new HashMap<>();
        String[] split = images.split(";");
        for (String s: split) {
            String[] innerSplit = s.split("=");
            map.put(innerSplit[0] , getImage(innerSplit[1]));
        }
        return map;
    }
    private String getImage(String str){
        return switch(str){
            case "SHIP1" -> Config.SHIP_IMAGE_REF1;
            case "SHIP2" -> Config.SHIP_IMAGE_REF2;
            default -> Config.SHIP_IMAGE_REF3;
        };
    }
    private Map<String, KeyCode> getKeyMap(String keyBoardSettings) {
        Map<String, KeyCode> map = new HashMap<>();
        if (keyBoardSettings != null) {
            String[] split = keyBoardSettings.split(";");
            for (String s : split) {
                String[] innerSplit = s.split("=");
                map.put(innerSplit[0], getKeyCode(innerSplit[1]));
            }
        }
        return map;
    }
    private KeyCode getKeyCode(String s){
        return switch(s){
            case "W" -> KeyCode.W;
            case "A" -> KeyCode.A;
            case "D" -> KeyCode.D;
            case "S" -> KeyCode.S;
            case "SPACE" -> KeyCode.SPACE;
            case "UP" -> KeyCode.UP;
            case "DOWN" -> KeyCode.DOWN;
            case "LEFT" -> KeyCode.LEFT;
            case "RIGHT" -> KeyCode.RIGHT;
            case "ENTER" -> KeyCode.ENTER;
            default -> KeyCode.Z;
        };
    }



    public List<String> getLines(String directory) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(directory))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public int getNbrOfPlayers() {
        return nbrOfPlayers;
    }

    public int getLivesPerPlayer() {
        return livesPerPlayer;
    }

    public int getAmountOfAsteroids() {
        return amountOfAsteroids;
    }

    public Map<String, KeyCode> getKeyMap() {
        return keyMap;
    }

    public Map<String, String> getImages() {
        return images;
    }
}
