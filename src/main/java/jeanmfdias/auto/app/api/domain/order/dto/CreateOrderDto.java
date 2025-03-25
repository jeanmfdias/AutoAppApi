package jeanmfdias.auto.app.api.domain.order.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record CreateOrderDto(@NotNull
                             @Positive
                             Double odometer,

                             @Positive
                             @JsonAlias("vehicle_id")
                             Long vehicleId,

                             @NotEmpty
                             List<CreateOrderItemDto> items) {
}
