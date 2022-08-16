package tas.uz.tasbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.uz.tasbackend.models.ACTIVE;
import tas.uz.tasbackend.models.News;
import tas.uz.tasbackend.repository.NewsRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NewsService {

    @Autowired
    final NewsRepo newsRepo;


    public List<News> getAll() {
        return newsRepo.findAll();
    }

    public News add(News news) {
        return newsRepo.save(news);
    }

    public News getbyid(Long id) {
        return newsRepo.getById(id);
    }

    public News remove(String id) {
        News news = newsRepo.getById(Long.parseLong(id));
        news.setActive(ACTIVE.NOACTIVE);
        return newsRepo.save(news);
    }
}
