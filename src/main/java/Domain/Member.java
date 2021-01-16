package Domain;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Nullable
    private String name;

    @Enumerated(EnumType.STRING)
    private GenType genType;

    private String email;

    private String tel;
}
