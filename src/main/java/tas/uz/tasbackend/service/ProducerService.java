package tas.uz.tasbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.uz.tasbackend.models.ACTIVE;
import tas.uz.tasbackend.models.Producer;
import tas.uz.tasbackend.repository.ProducerRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProducerService {

    @Autowired
    final ProducerRepo producerRepo;

    public Producer add(Producer producer){
        return producerRepo.save(producer);
    }

    public List<Producer> getall(){
        return producerRepo.getAllActive(ACTIVE.ACTIVE);
    }

    public Producer getbyid(Long id){
        return producerRepo.getById(id);
    }

    public Producer remove(String id){

        Producer producer = producerRepo.getById(Long.parseLong(id));
        producer.setActive(ACTIVE.NOACTIVE);
        return producerRepo.save(producer);
    }
}
