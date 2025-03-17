package jeanmfdias.auto.app.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jeanmfdias.auto.app.api.domain.order.dto.CreateOrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrderController {

    @PostMapping
    @Transactional
    public ResponseEntity<CreateOrderDto> create(@RequestBody @Valid CreateOrderDto createOrderDto) {
        return ResponseEntity.ok(createOrderDto);
    }

}
