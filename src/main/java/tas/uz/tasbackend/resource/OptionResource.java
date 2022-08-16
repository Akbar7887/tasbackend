package tas.uz.tasbackend.resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tas.uz.tasbackend.models.Option;
import tas.uz.tasbackend.models.OptionConstant;
import tas.uz.tasbackend.service.OptionService;

import java.util.List;

@Log4j2
@RequestMapping("/api/")
@RestController
@RequiredArgsConstructor
public class OptionResource {

    final OptionService optionService;

    @GetMapping("optionget")
    private ResponseEntity<List<Option>> getall() {
        return ResponseEntity.ok().body(optionService.getall());
    }

    @PostMapping("optionadd")
    private ResponseEntity<Option> add(@RequestBody Option option) {
        return ResponseEntity.ok().body(optionService.add(option));
    }

    @PostMapping("removeoption")
    private ResponseEntity<Option> remove(@RequestParam("id") String id) {
        return ResponseEntity.ok().body(optionService.remove(id));
    }

}
