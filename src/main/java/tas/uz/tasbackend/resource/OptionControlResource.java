package tas.uz.tasbackend.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tas.uz.tasbackend.models.Option;
import tas.uz.tasbackend.models.OptionConstant;
import tas.uz.tasbackend.service.OptionConstantService;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class OptionControlResource {

    final OptionConstantService optionConstantService;

    @PostMapping("optionConstantadd")
    private ResponseEntity<OptionConstant> add(@RequestBody OptionConstant optionConstant){
        return ResponseEntity.ok().body(optionConstantService.add(optionConstant));
    }

    @GetMapping("optionConstantget")
    private ResponseEntity<List<OptionConstant>> getall(){
        return ResponseEntity.ok().body(optionConstantService.getall());
    }

    @PostMapping("removeoptionconstant")
    private ResponseEntity<OptionConstant> remove(@RequestParam("id") String id){
        return ResponseEntity.ok().body(optionConstantService.remove(id));
    }
}
