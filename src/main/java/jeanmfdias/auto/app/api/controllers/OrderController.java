package jeanmfdias.auto.app.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jeanmfdias.auto.app.api.domain.order.dto.CreateOrderDto;
import jeanmfdias.auto.app.api.domain.order.dto.OrderDto;
import jeanmfdias.auto.app.api.domain.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
