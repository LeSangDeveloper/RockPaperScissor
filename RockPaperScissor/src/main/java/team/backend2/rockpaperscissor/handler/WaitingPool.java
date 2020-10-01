package team.backend2.rockpaperscissor.handler;
import team.backend2.rockpaperscissor.model.Room;

import java.util.HashMap;
import java.util.Map;

public class WaitingPool {
    private static WaitingPool instance;
    private static Map<String, Room> pool;
    private WaitingPool(){};

    public static WaitingPool getInstance(){
        if(instance == null){
            instance = new WaitingPool();
            pool = new HashMap<>();
        }
        return instance;
    }
    public Room findById(String uid1){
        return pool.get(uid1);
    }
    public Room newRoom(String uid1){
        Room newRoom = new Room(uid1);
        pool.put(uid1,null);
        return newRoom;
    }
}
