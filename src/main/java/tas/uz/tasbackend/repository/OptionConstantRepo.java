package tas.uz.tasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tas.uz.tasbackend.models.OptionConstant;


@Repository
public interface OptionConstantRepo extends JpaRepository<OptionConstant, Long> {
}
