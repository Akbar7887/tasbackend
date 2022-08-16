package tas.uz.tasbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.uz.tasbackend.models.Rate;
import tas.uz.tasbackend.repository.RateRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class RateService {

    @Autowired
   final RateRepo rateRepo;

    public List<Rate> getAll() {
        return rateRepo.findAll();
    }

    public Rate add(Rate rate) {
        return rateRepo.save(rate);
    }

    public void remove(Rate rate){
        rateRepo.delete(rate);
    }
}
