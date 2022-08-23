package tas.uz.tasbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.uz.tasbackend.models.ACTIVE;
import tas.uz.tasbackend.models.Model;
import tas.uz.tasbackend.models.Option;
import tas.uz.tasbackend.repository.ModelRepo;
import tas.uz.tasbackend.repository.OptionRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OptionService {

    @Autowired
    final OptionRepo optionRepo;
    final ModelRepo modelRepo;

    public List<Option> getall(){
        return optionRepo.getAllActive(ACTIVE.ACTIVE);
    }

    public Option add(Option option){

        return  optionRepo.save(option);
    }

    public Option remove(String id){
        Option option = optionRepo.getById(Long.parseLong(id));
        option.setActive(ACTIVE.NOACTIVE);
        return optionRepo.save(option);
    }
}
