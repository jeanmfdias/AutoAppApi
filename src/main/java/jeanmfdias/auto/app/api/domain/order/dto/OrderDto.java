package jeanmfdias.auto.app.api.domain.order.dto;

import jeanmfdias.auto.app.api.domain.order.Order;

public record OrderDto(Double odometer) {

    public OrderDto(Order order) {
        this(order.getOdometer());
    }

}
