package jeanmfdias.auto.app.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jeanmfdias.auto.app.api.domain.order.dto.CreateOrderDto;
import jeanmfdias.auto.app.api.domain.order.dto.OrderDto;
import jeanmfdias.auto.app.api.domain.order.dto.UpdateOrderDto;
import jeanmfdias.auto.app.api.domain.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @Transactional
    public ResponseEntity<OrderDto> create(@RequestBody @Valid CreateOrderDto createOrderDto) {
        OrderDto orderDto = new OrderDto(orderService.create(createOrderDto));
        return ResponseEntity.ok(orderDto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<OrderDto> update(@PathVariable(name = "id") Long id,
                                           @RequestBody @Valid UpdateOrderDto updateOrderDto) {
        OrderDto orderDto = new OrderDto(orderService.update(id, updateOrderDto));
        return ResponseEntity.ok(orderDto);
    }

}
