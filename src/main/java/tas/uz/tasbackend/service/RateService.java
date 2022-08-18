package tas.uz.tasbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.uz.tasbackend.models.Model;
import tas.uz.tasbackend.models.Rate;
import tas.uz.tasbackend.repository.RateRepo;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class RateService {

    @Autowired
    final RateRepo rateRepo;
//    @Autowired
    final ModelService modelService;


    public List<Rate> getAll() {
        return rateRepo.findAll();
    }

    public Rate add(Rate rate) {

        List<Model> models = modelService.getall();
        Rate rate1 = rateRepo.save(rate);

        Rate rate2 = maxDate();

        for (Model mod : models) {
            mod.setPriceuzs(mod.getPrice() * rate2.getCourse());
            modelService.create(mod);
        }
        return rate1;
    }

    public void remove(Rate rate) {
        rateRepo.delete(rate);
    }

    public Rate maxDate(){
        return  rateRepo.getMaxDate();
    }
}
