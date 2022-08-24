package tas.uz.tasbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.uz.tasbackend.models.*;
import tas.uz.tasbackend.repository.ModelRepo;
import tas.uz.tasbackend.repository.OptionRepo;
import tas.uz.tasbackend.repository.RateRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ModelService {

    @Autowired
    final ModelRepo modelRepo;
    final ProducerService producerService;
    final RateRepo rateRepo;
    final OptionRepo optionRepo;

    public Model add(Model model, String id) {


        Producer producer = producerService.getbyid(Long.parseLong(id));
        model.setProducername(producer.getName());
        producer.addModel(model);
        producerService.add(producer);
        Rate rate = rateRepo.getMaxDate();
        if (rate != null && model.getPrice() != null) {
            double res = model.getPrice() * rate.getCourse();
            model.setPriceuzs(res);
        }
        return modelRepo.save(model);
    }

    public Model create(Model model) {
        Rate rate = rateRepo.getMaxDate();
        if (rate != null && model.getPrice() != null) {
            double res = model.getPrice() * rate.getCourse();
            model.setPriceuzs(res);
        }
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

    public Model modeloption(Option option, String id) {
        Optional<Model> model = modelRepo.findById(Long.parseLong(id));
        Model model1;

        model1 = model.get();
        option.setActive(ACTIVE.ACTIVE);
        Option option1 =  optionRepo.save(option);

        model1.addOption(option1);
        return modelRepo.save(model1);
    }

}
