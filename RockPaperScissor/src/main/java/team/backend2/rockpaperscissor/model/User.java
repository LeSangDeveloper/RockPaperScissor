package team.backend2.rockpaperscissor.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    private String id;
    private String name;
    private Integer total_score;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
