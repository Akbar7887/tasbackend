package tas.uz.tasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tas.uz.tasbackend.models.ACTIVE;
import tas.uz.tasbackend.models.Producer;
import tas.uz.tasbackend.models.Section;

import java.util.List;

@Repository
public interface SectionRepo extends JpaRepository<Section, Long> {

}
