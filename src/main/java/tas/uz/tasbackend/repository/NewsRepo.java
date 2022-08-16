package tas.uz.tasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tas.uz.tasbackend.models.ACTIVE;
import tas.uz.tasbackend.models.News;
import tas.uz.tasbackend.models.Producer;

import java.util.List;

public interface NewsRepo extends JpaRepository<News, Long> {

    @Query("select p from News p where p.active = :active")
    List<News> getAllActive(ACTIVE active);
}
