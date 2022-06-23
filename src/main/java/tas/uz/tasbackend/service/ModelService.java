package tas.uz.tasbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.uz.tasbackend.models.Model;
import tas.uz.tasbackend.repository.ModelRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ModelService {

    @Autowired
    final ModelRepo modelRepo;

    public Model add(Model model){

        model.setProducername(model.getProducer().getName());
        return modelRepo.save(model);
    }

    public List<Model> getall(){
        return modelRepo.findAll();
    }

    public Model getbyid(Long id){
        return modelRepo.getById(id);
    }



}
