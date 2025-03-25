package jeanmfdias.auto.app.api.domain.order.services;

import jeanmfdias.auto.app.api.domain.order.Order;
import jeanmfdias.auto.app.api.domain.order.OrderItem;
import jeanmfdias.auto.app.api.domain.order.dto.CreateOrderDto;
import jeanmfdias.auto.app.api.domain.order.dto.UpdateOrderDto;
import jeanmfdias.auto.app.api.domain.order.repositories.OrderItemRepository;
import jeanmfdias.auto.app.api.domain.order.repositories.OrderRepository;
import jeanmfdias.auto.app.api.domain.vehicle.repositories.VehicleRepository;
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
    private VehicleRepository vehicleRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public Order create(CreateOrderDto dto) {
        var order = new Order(dto);
        var vehicle = this.vehicleRepository.getReferenceById(dto.vehicleId());
        order.setVehicle(vehicle);

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

    public boolean delete(Long id) {
        var order = this.orderRepository.getReferenceById(id);
        this.removeItems(order);
        this.orderRepository.delete(order);

        if (this.orderRepository.existsById(id)) {
            return false;
        }
        return true;
    }

    private void removeItems(Order order) {
        order.getItems().forEach(item -> {
            var oi = this.orderItemRepository.getReferenceById(item.getId());
            this.orderItemRepository.delete(oi);
        });
    }

}
