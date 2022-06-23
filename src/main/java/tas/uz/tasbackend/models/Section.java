package tas.uz.tasbackend.models;

import javax.persistence.*;

@Entity
@Table
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String nameuz;

    private String imagepath;

    public Section() {
    }

    public Section(Long id, String name, String nameuz, String imagepath) {
        this.id = id;
        this.name = name;
        this.nameuz = nameuz;
        this.imagepath = imagepath;
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

    public String getNameuz() {
        return nameuz;
    }

    public void setNameuz(String nameuz) {
        this.nameuz = nameuz;
    }
}
