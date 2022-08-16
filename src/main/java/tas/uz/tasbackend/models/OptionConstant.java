package tas.uz.tasbackend.models;

import javax.persistence.*;

@Entity
@Table(name = "option_constant")
public class OptionConstant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String namerus;

    @Column(unique = true)
    private String nameuz;

    @Enumerated(EnumType.STRING)
    private ACTIVE active = ACTIVE.ACTIVE;

    public OptionConstant() {
    }

    public OptionConstant(Long id, String namerus, String nameuz, ACTIVE active) {
        this.id = id;
        this.namerus = namerus;
        this.nameuz = nameuz;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamerus() {
        return namerus;
    }

    public void setNamerus(String namerus) {
        this.namerus = namerus;
    }

    public String getNameuz() {
        return nameuz;
    }

    public void setNameuz(String nameuz) {
        this.nameuz = nameuz;
    }

    public ACTIVE getActive() {
        return active;
    }

    public void setActive(ACTIVE active) {
        this.active = active;
    }
}
