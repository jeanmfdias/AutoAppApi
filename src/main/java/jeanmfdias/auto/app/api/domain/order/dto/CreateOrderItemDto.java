package jeanmfdias.auto.app.api.domain.order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jeanmfdias.auto.app.api.domain.order.Type;

public record CreateOrderItemDto(@NotBlank
                                 String description,

                                 @NotNull
                                 Type type,

                                 @NotNull
                                 @Positive
                                 Double value) {
}
