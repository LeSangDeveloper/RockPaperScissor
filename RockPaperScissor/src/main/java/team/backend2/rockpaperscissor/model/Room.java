package team.backend2.rockpaperscissor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "rooms")
public class Room {

    private String id;
    private String uid_1;
    private String uid_2;
    private String winner;
    private LocalDateTime start_time;
    private String time_out;

    public Room() {
    }

    public Room(String uid_1, String uid_2) {
        this.id = UUID.randomUUID().toString();
        this.uid_1 = uid_1;
        this.uid_2 = uid_2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "uid_1", nullable = false)
    public String getUid_1() {
        return uid_1;
    }
    public void setUid_1(String uid_1) {
        this.uid_1 = uid_1;
    }

    @Column(name = "uid_2", nullable = false)
    public String getUid_2() {
        return uid_2;
    }
    public void setUid_2(String uid_2) {
        this.uid_2 = uid_2;
    }

    @Column(name = "winner", nullable = true)
    public String getWinner() {
        return winner;
    }
    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Column(name = "start_time", nullable = false)
    public LocalDateTime getStart_time() {
        return start_time;
    }
    public void setStart_time(LocalDateTime uid_2) {
        this.start_time = start_time;
    }
//    @Override
//    public String toString() {
//        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
//                + "]";
//    }

}