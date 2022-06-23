package tas.uz.tasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tas.uz.tasbackend.models.CustomerOrder;

@Repository
public interface CustomerOrderRepo extends JpaRepository<CustomerOrder, Long> {
}
