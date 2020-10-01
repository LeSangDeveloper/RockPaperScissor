package team.backend2.rockpaperscissor.model;

import javax.persistence.*;
import java.util.UUID;

//Keo = 1
//Bua = 2
//Bao = 3
// -1: u1 win , 1: u2 win , 0: tie
@Entity
@Table(name = "rounds")
public class Round {
    private String id;
    private Integer pick_1;
    private Integer pick_2;
    private Integer winner;

    public Round(){
        this.id = UUID.randomUUID().toString();
    }

    public boolean isfinish(){
        if(this.pick_1 != null && this.pick_2 != null) {
            switch (this.pick_1-this.pick_2) {
                case 0:
                    winner = 0;
                    break;
                case 1:
                case -2:
                    winner = -1;
                    break;
                case -1:
                case 2:
                    winner = 1;
                    break;
            }
            return true;
        }
        return false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "pick_2", nullable = true)
    public Integer getPick_2() {
        return pick_2;
    }
    public void setPick_2(Integer pick_2) {
        this.pick_2 = pick_2;
    }

    @Column(name ="pick_1", nullable = true)
    public Integer getPick_1(){
        return pick_1;
    }
    public void setPick_1(Integer pick_1){this.pick_1 = pick_1;};

    @Column(name = "winner", nullable = true)
    public Integer getWinner() {
        isfinish();
        return winner;
    }
    public void setWinner(Integer winner) {
        this.winner = winner;
    }
}
