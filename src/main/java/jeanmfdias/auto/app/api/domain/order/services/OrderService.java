package jeanmfdias.auto.app.api.domain.order.services;

import jeanmfdias.auto.app.api.domain.order.Order;
import jeanmfdias.auto.app.api.domain.order.dto.CreateOrderDto;
import jeanmfdias.auto.app.api.domain.order.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order create(CreateOrderDto dto) {
        var order = new Order(dto);
        this.orderRepository.save(order);
        return order;
    }

}
