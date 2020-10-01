package team.backend2.rockpaperscissor.handler;

import team.backend2.rockpaperscissor.model.Game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamePool {
    private static GamePool instance;
    private static Map<String,Game> pool;
    private GamePool(){};

    public static GamePool getInstance(){
        if(instance == null){
            instance = new GamePool();
            pool = new HashMap<>();
        }
        return instance;
    }
    public Game findById(String gameId){
        return pool.get(gameId);
    }
}
