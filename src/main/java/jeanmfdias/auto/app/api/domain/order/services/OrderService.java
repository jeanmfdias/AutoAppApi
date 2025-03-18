package jeanmfdias.auto.app.api.domain.order.services;

import jeanmfdias.auto.app.api.domain.order.Order;
import jeanmfdias.auto.app.api.domain.order.OrderItem;
import jeanmfdias.auto.app.api.domain.order.dto.CreateOrderDto;
import jeanmfdias.auto.app.api.domain.order.dto.UpdateOrderDto;
import jeanmfdias.auto.app.api.domain.order.repositories.OrderItemRepository;
import jeanmfdias.auto.app.api.domain.order.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public Order create(CreateOrderDto dto) {
        var order = new Order(dto);
        this.orderRepository.save(order);
        return order;
    }

    public Order update(Long id, UpdateOrderDto dto) {
        var order = this.orderRepository.getReferenceById(id);
        if (!dto.odometer().isNaN()) {
            order.setOdometer(dto.odometer());
        }
        if (!dto.items().isEmpty()) {
            List<OrderItem> orderItems = new ArrayList<>(dto.items().stream()
                    .map(OrderItem::new)
                    .toList());
            orderItems.forEach(oi -> oi.setOrder(order));

            this.removeItems(order);

            order.setItems(orderItems);
        }
        order.setUpdatedAt(LocalDateTime.now());
        this.orderRepository.save(order);
        return order;
    }

    private void removeItems(Order order) {
        order.getItems().forEach(item -> {
            var oi = this.orderItemRepository.getReferenceById(item.getId());
            this.orderItemRepository.delete(oi);
        });
    }

}
