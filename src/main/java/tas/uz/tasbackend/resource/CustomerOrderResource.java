package tas.uz.tasbackend.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tas.uz.tasbackend.models.CustomerOrder;
import tas.uz.tasbackend.service.CustomerOrderService;

import java.util.List;

@RequestMapping("/api/")
@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class CustomerOrderResource {

    final CustomerOrderService customerOrderService;

    @CrossOrigin
    @GetMapping("customerorderget")
    private ResponseEntity<List<CustomerOrder>> getall() {
        return ResponseEntity.ok().body(customerOrderService.getAll());
    }

    @CrossOrigin
    @PostMapping("customerorderpost")
    private ResponseEntity<CustomerOrder> add(@RequestBody CustomerOrder customerOrder) {
        return ResponseEntity.ok().body(customerOrderService.add(customerOrder));
    }

}
