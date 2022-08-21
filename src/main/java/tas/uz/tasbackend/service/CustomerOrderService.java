package tas.uz.tasbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.uz.tasbackend.models.ACTIVE;
import tas.uz.tasbackend.models.Customer;
import tas.uz.tasbackend.models.CustomerOrder;
import tas.uz.tasbackend.repository.CustomerOrderRepo;
import tas.uz.tasbackend.repository.CustomerRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerOrderService {

    @Autowired
    final CustomerOrderRepo customerOrderRepo;
    final CustomerRepo customerRepo;

    public List<CustomerOrder> getAll() {
        return customerOrderRepo.findAll();
    }

    public CustomerOrder save(CustomerOrder customerOrder) {
        return customerOrderRepo.save(customerOrder);
    }

    public CustomerOrder remove(CustomerOrder customerOrder) {

        if (customerOrder.getActive() == ACTIVE.ACTIVE) {
            customerOrder.setActive(ACTIVE.NOACTIVE);
        } else {
            customerOrder.setActive(ACTIVE.ACTIVE);
        }
        return customerOrderRepo.save(customerOrder);
    }

    public CustomerOrder add(CustomerOrder customerOrder, String id) {

        Customer customer = customerRepo.getById(Long.parseLong(id));
        customerOrder.setCustomer(customer);
        return customerOrderRepo.save(customerOrder);
    }
}
