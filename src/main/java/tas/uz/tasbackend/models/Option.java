package tas.uz.tasbackend.models;

import javax.persistence.*;

@Entity
@Table
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "optionconstant_id", referencedColumnName = "id", unique = true)
    private OptionConstant optionConstant;


    private String optionname;

    @Enumerated(EnumType.STRING)
    private ACTIVE active = ACTIVE.ACTIVE;

    public Option() {
    }

    public Option(Long id, OptionConstant optionConstant, String optionname, ACTIVE active) {
        this.id = id;
        this.optionConstant = optionConstant;
        this.optionname = optionname;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OptionConstant getOptionConstant() {
        return optionConstant;
    }

    public void setOptionConstant(OptionConstant optionConstant) {
        this.optionConstant = optionConstant;
    }

    public String getOptionname() {
        return optionname;
    }

    public void setOptionname(String optionname) {
        this.optionname = optionname;
    }

    public ACTIVE getActive() {
        return active;
    }

    public void setActive(ACTIVE active) {
        this.active = active;
    }
}
