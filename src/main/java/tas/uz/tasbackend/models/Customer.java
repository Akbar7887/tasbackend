package tas.uz.tasbackend.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(name = "email")
    private String email;



    public Customer() {
    }

    public Customer(Long id, String name, String phone, String email, Set<CustomerOrder> customerOrders) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

//    public void addCustomerOrder(CustomerOrder customerOrder) {
//        if (!this.customerOrders.contains(customerOrder)) {
//            this.customerOrders.add(customerOrder);
//            customerOrder.setCustomer(this);
//        }
//    }
//
//    public void removeCustomerOrder(CustomerOrder customerOrder) {
//        if (this.customerOrders.contains(customerOrder)) {
//            this.customerOrders.remove(customerOrder);
//            customerOrder.setCustomer(null);
//        }
//    }

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

//    @JsonIgnore
//    public Set<CustomerOrder> getCustomerOrders() {
//        return customerOrders;
//    }
//
//    public void setCustomerOrders(Set<CustomerOrder> customerOrders) {
//        this.customerOrders = customerOrders;
//    }


}

