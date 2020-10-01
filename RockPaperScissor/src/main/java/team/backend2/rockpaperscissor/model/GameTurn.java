package team.backend2.rockpaperscissor.model;

public class GameTurn {
    private String uid;
    private String room_id;
    private Integer choose;

    public Integer getChoose() {
        return choose;
    }

    public String getRoom_id() {
        return room_id;
    }

    public String getUid() {
        return uid;
    }
}
