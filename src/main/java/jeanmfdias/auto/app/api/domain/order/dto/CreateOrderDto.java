package jeanmfdias.auto.app.api.domain.order.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record CreateOrderDto(@NotNull
                             @Positive
                             Double odometer,

                             @NotEmpty
                             List<CreateOrderItemDto> items) {
}
