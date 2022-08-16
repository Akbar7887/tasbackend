package tas.uz.tasbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.uz.tasbackend.models.ACTIVE;
import tas.uz.tasbackend.models.Customer;
import tas.uz.tasbackend.models.CustomerOrder;
import tas.uz.tasbackend.repository.CustomerRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @Autowired
    final CustomerRepo customerRepo;

    public List<Customer> getAll(){
        return customerRepo.getAllActive(ACTIVE.ACTIVE);
    }

    public Customer add(Customer customer){

        Customer findCustomer = customerRepo.findByPhone(customer.getPhone());
        if (findCustomer != null){
            for (CustomerOrder cus : customer.getCustomerOrders()){
                findCustomer.addCustomerOrder(cus);
            }
            return customerRepo.save(findCustomer);
        }
        return customerRepo.save(customer);

    }
}
