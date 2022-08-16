package tas.uz.tasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tas.uz.tasbackend.models.Rate;

public interface RateRepo extends JpaRepository<Rate, Long> {

}
