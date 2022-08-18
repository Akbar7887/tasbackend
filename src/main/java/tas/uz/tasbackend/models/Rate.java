package tas.uz.tasbackend.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rate")
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Exchange exchange = Exchange.USD;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "currentdate")
//    @CreationTimestamp
    private Date currentdate;

    private double course;


    public Rate() {
    }

    public Rate(Long id, Exchange exchange, Date currentdate, double course) {
        this.id = id;
        this.exchange = exchange;
        this.currentdate = currentdate;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {

        this.exchange = Exchange.USD;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }

    public Date getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(Date currentdate) {
        this.currentdate = currentdate;
    }
}
