package lpnu.resource;

import lpnu.dto.OrderDTO;
import lpnu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderResource {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderDTO findById(final @PathVariable Long id) {
        return orderService.findById(id);
    }

    @PostMapping
    public OrderDTO createOrder(final @RequestBody @Validated OrderDTO orderDTO) {
        return orderService.create(orderDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(final @PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }
}
