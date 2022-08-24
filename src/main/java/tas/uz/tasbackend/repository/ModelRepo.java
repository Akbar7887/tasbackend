package tas.uz.tasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tas.uz.tasbackend.models.ACTIVE;
import tas.uz.tasbackend.models.Model;

import java.util.List;

@Repository
public interface ModelRepo extends JpaRepository<Model, Long> {

    @Query("select m from Model m where  m.active = :active")
    List<Model> getAllModels(ACTIVE active);
}
