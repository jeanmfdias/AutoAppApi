package jeanmfdias.auto.app.api.domain.order.dto;

import jeanmfdias.auto.app.api.domain.order.Order;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public record OrderDto(Long id,
                       VehicleDto vehicle,
                       Double odometer,
                       List<OrderItemDto> items,
                       LocalDateTime createdAt,
                       LocalDateTime updatedAt) {

    public OrderDto(Order order) {
        this(order.getId(),
                new VehicleDto(order.getVehicle()),
                order.getOdometer(),
                Optional.ofNullable(order.getItems())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(OrderItemDto::new)
                        .toList(),
                order.getCreatedAt(),
                order.getUpdatedAt());
    }

}
