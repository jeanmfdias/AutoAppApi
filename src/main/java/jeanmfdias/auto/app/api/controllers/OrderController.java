package jeanmfdias.auto.app.api.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jeanmfdias.auto.app.api.domain.order.dto.CreateOrderDto;
import jeanmfdias.auto.app.api.domain.order.dto.OrderDto;
import jeanmfdias.auto.app.api.domain.order.dto.UpdateOrderDto;
import jeanmfdias.auto.app.api.domain.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final ObjectMapper objectMapper;

    @Autowired
    private OrderService orderService;

    public OrderController() {
        this.objectMapper = new ObjectMapper();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<OrderDto> create(@RequestBody @Valid CreateOrderDto createOrderDto) {
        OrderDto orderDto = new OrderDto(orderService.create(createOrderDto));
        return ResponseEntity.ok(orderDto);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<OrderDto> update(@PathVariable(name = "id") Long id,
                                           @RequestBody @Valid UpdateOrderDto updateOrderDto) {
        OrderDto orderDto = new OrderDto(orderService.update(id, updateOrderDto));
        return ResponseEntity.ok(orderDto);
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) throws JsonProcessingException {
        var success = this.orderService.delete(id);
        if (success) {
            var json = Map.of("message", "success");
            return ResponseEntity.ok(this.objectMapper.writeValueAsString(json));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<Page<OrderDto>> getAll(@PageableDefault(size = 10, sort = "vehicleId") Pageable pageable) {
        var page = this.orderService.getAll(pageable)
                .map(OrderDto::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("vehicle/{id}")
    public ResponseEntity<Page<OrderDto>> getAllByVehicle(@PageableDefault(size = 10, sort = "createdAt")
                                                              Pageable pagination,
                                                          @PathVariable(name = "id") Long vehicleId) {
        var page = this.orderService.getAllByVehicle(vehicleId, pagination)
                .map(OrderDto::new);

        return ResponseEntity.ok(page);
    }

}
