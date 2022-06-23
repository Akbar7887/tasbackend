package tas.uz.tasbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.uz.tasbackend.models.Model;
import tas.uz.tasbackend.models.Section;
import tas.uz.tasbackend.repository.SectionRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionService {

    @Autowired
    private final SectionRepo sectionRepo;

    public Section add(Section section) {
        return sectionRepo.save(section);
    }

    public List<Section> get() {
        return sectionRepo.findAll();
    }

    public Section getbyid(Long id){
        return sectionRepo.getById(id);
    }
}
