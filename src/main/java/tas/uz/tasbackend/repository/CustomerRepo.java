package tas.uz.tasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tas.uz.tasbackend.models.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Customer findByPhone(String phone);
}
