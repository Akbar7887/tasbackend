package tas.uz.tasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tas.uz.tasbackend.models.Section;

@Repository
public interface SectionRepo extends JpaRepository<Section, Long> {
}
