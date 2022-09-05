package tas.uz.tasbackend.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String titleuz;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT", name = "descriptionuz")
    private String descriptionuz;


    private String imagepath;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "currentdate")
    @CreationTimestamp
    private Date date;

    @Enumerated(EnumType.STRING)
    private ACTIVE active = ACTIVE.ACTIVE;

    public News() {
    }

    public News(Long id, String title, String titleuz, String description, String descriptionuz, String imagepath, Date date, ACTIVE active) {
        this.id = id;
        this.title = title;
        this.titleuz = titleuz;
        this.description = description;
        this.descriptionuz = descriptionuz;
        this.imagepath = imagepath;
        this.date = date;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ACTIVE getActive() {
        return active;
    }

    public void setActive(ACTIVE active) {
        this.active = active;
    }

    public String getDescriptionuz() {
        return descriptionuz;
    }

    public void setDescriptionuz(String descriptionuz) {
        this.descriptionuz = descriptionuz;
    }

    public String getTitleuz() {
        return titleuz;
    }

    public void setTitleuz(String titleuz) {
        this.titleuz = titleuz;
    }
}
