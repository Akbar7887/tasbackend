package tas.uz.tasbackend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private Model model;

    @OneToMany(mappedBy = "customer",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<CustomerOrder> customerOrders;

    public Customer() {
    }

    public Customer(Long id, String name, String phone, String email, Model model, Set<CustomerOrder> customerOrders) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.model = model;
        this.customerOrders = customerOrders;
    }

    public void addCustomerOrder(CustomerOrder customerOrder) {
        if (!this.customerOrders.contains(customerOrder)) {
            this.customerOrders.add(customerOrder);
            customerOrder.setCustomer(this);
        }
    }

    public void removeCustomerOrder(CustomerOrder customerOrder) {
        if (this.customerOrders.contains(customerOrder)) {
            this.customerOrders.remove(customerOrder);
            customerOrder.setCustomer(null);
        }
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(Set<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
