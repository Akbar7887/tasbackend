package tas.uz.tasbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.uz.tasbackend.models.OptionConstant;
import tas.uz.tasbackend.repository.OptionConstantRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class OptionConstantService {

    @Autowired
    final OptionConstantRepo optionConstantRepo;

    public List<OptionConstant> getall(){
        return optionConstantRepo.findAll();
    }

    public OptionConstant add(OptionConstant optionConstant){
        return optionConstantRepo.save(optionConstant);
    }
}
