package jeanmfdias.auto.app.api.domain.vehicle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jeanmfdias.auto.app.api.domain.order.dto.OrderDto;
import jeanmfdias.auto.app.api.domain.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public record VehicleDto(Long id,

                         String brand,

                         String model,

                         @JsonProperty("factory_year")
                         Long factoryYear,

                         @JsonProperty("model_year")
                         Long modelYear,

                         @JsonProperty("acquired_price")
                         Double acquiredPrice,

                         @JsonProperty("created_at")
                         LocalDateTime createdAt,

                         @JsonProperty("updated_at")
                         LocalDateTime updatedAt,

                         List<OrderDto> orders) {

    public VehicleDto(Vehicle vehicle) {
        this(vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getFactoryYear(),
                vehicle.getModelYear(),
                vehicle.getAcquiredPrice(),
                vehicle.getCreatedAt(),
                vehicle.getUpdatedAt(),
                Optional.ofNullable(vehicle.getOrders())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(OrderDto::new)
                        .toList());
    }

}
