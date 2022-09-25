package tas.uz.tasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tas.uz.tasbackend.models.ACTIVE;
import tas.uz.tasbackend.models.Customer;
import tas.uz.tasbackend.models.Producer;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    @Query("select   ph from Customer ph where ph.phone=:phone")
    Customer findPhone(@Param("phone") String phone);

//    @Query("select p from Customer p where p.active = :active")
//    List<Customer> getAllActive(ACTIVE active);
}