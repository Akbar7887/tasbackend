package tas.uz.tasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tas.uz.tasbackend.models.ACTIVE;
import tas.uz.tasbackend.models.OptionConstant;
import tas.uz.tasbackend.models.Producer;

import java.util.List;


@Repository
public interface OptionConstantRepo extends JpaRepository<OptionConstant, Long> {

    @Query("select p from OptionConstant p where p.active = :active")
    List<OptionConstant> getAllActive(ACTIVE active);
}
