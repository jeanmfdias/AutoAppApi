package jeanmfdias.auto.app.api.domain.order.dto;

import jeanmfdias.auto.app.api.domain.order.OrderItem;

public record OrderItemDto(String description) {

    public OrderItemDto(OrderItem orderItem) {
        this(orderItem.getDescription());
    }

}
