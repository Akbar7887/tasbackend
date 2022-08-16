package tas.uz.tasbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.uz.tasbackend.models.ACTIVE;
import tas.uz.tasbackend.models.Model;
import tas.uz.tasbackend.models.Producer;
import tas.uz.tasbackend.repository.ModelRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ModelService {

    @Autowired
    final ModelRepo modelRepo;
    final ProducerService producerService;

    public Model add(Model model, String id) {


        Producer producer = producerService.getbyid(Long.parseLong(id));
        model.setProducername(producer.getName());
        producer.addModel(model);
        producerService.add(producer);
        return modelRepo.save(model);
    }

    public Model create(Model model) {
        return modelRepo.save(model);
    }
    public Model remove(String id) {

        Model model = modelRepo.getById(Long.parseLong(id));
        model.setActive(ACTIVE.NOACTIVE);
        return modelRepo.save(model);
    }



    public List<Model> getall() {
        return modelRepo.getAllModels(ACTIVE.ACTIVE);
    }

    public Model getbyid(Long id) {
        return modelRepo.getById(id);
    }


}
