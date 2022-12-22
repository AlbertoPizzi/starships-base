package config;

import game.KeyAction;
import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KeyMap {
    public Map<KeyAction , KeyCode> keyMap;
    public KeyMap(){
        this.keyMap = new HashMap<>();
    }

    public Map<KeyAction, KeyCode> getKeyMap() {
        return keyMap;
    }
    public Set<KeyAction> getActions(){
        return keyMap.keySet();
    }
    public List<KeyCode> getKeys(){
        return (List<KeyCode>)keyMap.values();
    }
}

