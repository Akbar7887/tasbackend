package tas.uz.tasbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.uz.tasbackend.models.Option;
import tas.uz.tasbackend.repository.OptionRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionService {

    @Autowired
    final OptionRepo optionRepo;

    public List<Option> getall(){
        return optionRepo.findAll();
    }

    public Option add(Option option){
        return  optionRepo.save(option);
    }
}
