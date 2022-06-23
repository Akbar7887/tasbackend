package tas.uz.tasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tas.uz.tasbackend.models.News;

public interface NewsRepo extends JpaRepository<News, Long> {
}
