package tas.uz.tasbackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tas.uz.tasbackend.models.ACTIVE;
import tas.uz.tasbackend.models.Producer;

import java.util.List;


@Repository
public interface ProducerRepo extends JpaRepository<Producer, Long> {

   @Query("select p from Producer p where p.active = :active")
   List<Producer> getAllActive(ACTIVE active);
}
