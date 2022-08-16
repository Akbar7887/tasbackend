package tas.uz.tasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tas.uz.tasbackend.models.ACTIVE;
import tas.uz.tasbackend.models.Option;
import tas.uz.tasbackend.models.Producer;

import java.util.List;

@Repository
public interface OptionRepo extends JpaRepository<Option, Long> {
    @Query("select p from Option p where p.active = :active")
    List<Option> getAllActive(ACTIVE active);
}
