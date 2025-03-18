package jeanmfdias.auto.app.api.domain.order.dto;

import jeanmfdias.auto.app.api.domain.order.Order;

import java.time.LocalDate;
import java.util.List;

public record OrderDto(Long id,
                       Double odometer,
                       List<OrderItemDto> items,
                       LocalDate createdAt,
                       LocalDate updatedAt) {

    public OrderDto(Order order) {
        this(order.getId(),
                order.getOdometer(),
                order.getItems().stream()
                        .map(OrderItemDto::new)
                        .toList(),
                order.getCreatedAt(),
                order.getUpdatedAt());
    }

}
