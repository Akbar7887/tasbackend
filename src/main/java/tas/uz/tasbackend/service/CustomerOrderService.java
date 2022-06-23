package tas.uz.tasbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.uz.tasbackend.models.CustomerOrder;
import tas.uz.tasbackend.repository.CustomerOrderRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerOrderService {

    @Autowired
    final CustomerOrderRepo customerOrderRepo;

    public List<CustomerOrder> getAll(){
        return customerOrderRepo.findAll();
    }

    public CustomerOrder add(CustomerOrder customerOrder){
        return customerOrderRepo.save(customerOrder);
    }
}
