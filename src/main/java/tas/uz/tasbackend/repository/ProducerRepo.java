package tas.uz.tasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tas.uz.tasbackend.models.Producer;

@Repository
public interface ProducerRepo extends JpaRepository<Producer, Long> {
}
