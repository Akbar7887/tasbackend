package tas.uz.tasbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(unique = true)
    private String name;

    private Double price;

    private Double priceuzs;

    private String producername;

    private String imagepath;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String descriptionuz;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producer_id", referencedColumnName = "id")
    @JsonBackReference
    private Producer producer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    private Section section;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "model_option",
            joinColumns = @JoinColumn(name = "model_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id"), foreignKey = @ForeignKey(name = "model_option_fk"))
    private List<Option> optionSet = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    private ACTIVE active = ACTIVE.ACTIVE;


    public Model() {
    }

    public Model(Long id, String name, Double price, Double priceuzs, String producername, String imagepath, String description, String descriptionuz, Producer producer, Section section, List<Option> optionSet, ACTIVE active) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.priceuzs = priceuzs;
        this.producername = producername;
        this.imagepath = imagepath;
        this.description = description;
        this.descriptionuz = descriptionuz;
        this.producer = producer;
        this.section = section;
        this.optionSet = optionSet;
        this.active = active;
    }

    public void addOption(Option option) {
        if (!this.optionSet.contains(option)) {
            this.optionSet.add(option);
        }
    }

    public void removeOption(Option option) {
        if (this.optionSet.contains(option)) {
            this.optionSet.remove(option);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public ACTIVE getActive() {
        return active;
    }

    public void setActive(ACTIVE active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Option> getOptionSet() {
        List<Option> removelist = new ArrayList<Option>();
        for (Option option : optionSet) {
            if (option.getActive() == ACTIVE.NOACTIVE) {
                removelist.add(option);
            }
        }
        optionSet.removeAll(removelist);
        return optionSet;
    }

    public void setOptionSet(List<Option> optionSet) {
        this.optionSet = optionSet;
    }

    public String getProducername() {
        return producername;
    }

    public void setProducername(String producername) {
        this.producername = producername;
    }

    public String getDescriptionuz() {
        return descriptionuz;
    }

    public void setDescriptionuz(String descriptionuz) {
        this.descriptionuz = descriptionuz;
    }

    public Double getPriceuzs() {
        return priceuzs;
    }

    public void setPriceuzs(Double priceuzs) {
        this.priceuzs = priceuzs;
    }
}
