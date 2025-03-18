package jeanmfdias.auto.app.api.domain.order.dto;

import jakarta.validation.constraints.Positive;

import java.util.List;

public record UpdateOrderDto(@Positive
                             Double odometer,

                             List<UpdateOrderItemDto> items) {
}
