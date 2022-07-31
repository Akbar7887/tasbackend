package tas.uz.tasbackend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imagepath;

    @OneToMany(mappedBy = "producer")
    @JsonManagedReference
    private Set<Model> modelSet;

    private String country;

    private String countryuz;

    @Enumerated(EnumType.STRING)
    private ACTIVE active = ACTIVE.ACTIVE;


    public void addModel(Model model){
        if(!modelSet.contains(model)){
            modelSet.add(model);
            model.setProducer(this);
        }
    }

    public void removeModel(Model model){
        if(modelSet.contains(model)){
            modelSet.remove(model);
            model.setProducer(null);
        }
    }

    public Producer() {
    }

    public Producer(Long id, String name, String imagepath, Set<Model> modelSet, String country, String countryuz, ACTIVE active) {
        this.id = id;
        this.name = name;
        this.imagepath = imagepath;
        this.modelSet = modelSet;
        this.country = country;
        this.countryuz = countryuz;
        this.active = active;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryuz() {
        return countryuz;
    }

    public void setCountryuz(String countryuz) {
        this.countryuz = countryuz;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Model> getModelSet() {
        return modelSet;
    }

    public void setModelSet(Set<Model> modelSet) {
        this.modelSet = modelSet;
    }

    public ACTIVE getActive() {
        return active;
    }

    public void setActive(ACTIVE active) {
        this.active = active;
    }
}
