package jeanmfdias.auto.app.api.domain.order.dto;

import jakarta.validation.constraints.Positive;
import jeanmfdias.auto.app.api.domain.order.Type;

public record UpdateOrderItemDto(String description, Type type, @Positive Double value) {
}
