package team.backend2.rockpaperscissor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

public class Room {
    private String uid_2;
    private String gameId;
    private LocalDateTime start_time;
    private String time_out;

    private Room() {
    }

    public Room(String uid_2) {
        this.uid_2 = uid_2;
    }
    public String getGameId() {
        return gameId;
    }
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getUid_2() {
        return uid_2;
    }
    public void setUid_2(String uid_2) {
        this.uid_2 = uid_2;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }
    public void setStart_time(LocalDateTime uid_2) {
        this.start_time = start_time;
    }

}