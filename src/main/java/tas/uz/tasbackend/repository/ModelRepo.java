package tas.uz.tasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tas.uz.tasbackend.models.Model;

@Repository
public interface ModelRepo extends JpaRepository<Model, Long> {

//    @Query(value = "select m.id, m.producer.name as producer, m.name, m.imagepath, m.section from Model m ", nativeQuery = true)
//    List<Model> getAllModels();
}
