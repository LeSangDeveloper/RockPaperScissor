package team.backend2.rockpaperscissor.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "games")
public class Game {
    private String id;
    private String uid_1;
    private String uid_2;
    private String winner;
    private Integer balanceScore;

    private Integer roundOrder;
    private List<Round> rounds;

    private String start_time;
    private String time_out;
    public Game(String uid_1, String uid_2){
        this.id = UUID.randomUUID().toString();
        this.uid_1 = uid_1;
        this.uid_2 = uid_2;
        this.balanceScore = 0;
        this.roundOrder = 0;
        this.rounds = new ArrayList<>();

        this.rounds.add(new Round());
        this.rounds.add(new Round());
        this.rounds.add(new Round());
    }

    public Game() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public boolean isfinish(){
        if(roundOrder >= 2) {
            System.out.println("Finish");
            if (balanceScore > 0) winner = uid_2;
            else if (balanceScore < 0) winner = uid_1;

            return true;
        }
        return false;
    }
    public String update(String uid, Integer choose){
        Round curRound = rounds.get(roundOrder);
        if(roundOrder >= 2) {
            Integer win = curRound.getWinner();
            if(win == 1) {
                if (uid.equals(uid_2))
                    return "Round Win";
                if (uid.equals(uid_1))
                    return "Round Lose";
            }else if( win == -1)
            {
                if (uid.equals(uid_1))
                    return "Round Win";
                if (uid.equals(uid_2))
                    return "Round Lose";
            }
            return "Round Tie";
        };

        if(uid.equals(uid_1) && curRound.getPick_1() == null) {
            curRound.setPick_1(choose);
        }
        if(uid.equals(uid_2) && curRound.getPick_2() == null) {
            curRound.setPick_2(choose);
        }
        if(curRound.isfinish()) {
            if(roundOrder < 2) roundOrder++;
            Integer win = curRound.getWinner();
            balanceScore += win;
            if(win == 1) {
                if (uid.equals(uid_2))
                    return "Round Win";
                if (uid.equals(uid_1))
                    return "Round Lose";
            }else if( win == -1)
            {
                if (uid.equals(uid_1))
                    return "Round Win";
                if (uid.equals(uid_2))
                    return "Round Lose";
            }
            return "Round Tie";

        }
        return "Waiting";
    }
    @Column(name = "winner", nullable = true)
    public String getWinner() {
        return winner;
    }
    public void setWinner(String winner) {
        this.winner = winner;
    }
}
