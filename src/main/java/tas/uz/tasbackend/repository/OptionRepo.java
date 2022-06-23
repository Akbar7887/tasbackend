package tas.uz.tasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tas.uz.tasbackend.models.Option;

@Repository
public interface OptionRepo extends JpaRepository<Option, Long> {

}
