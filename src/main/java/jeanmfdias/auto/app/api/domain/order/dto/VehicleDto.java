package jeanmfdias.auto.app.api.domain.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jeanmfdias.auto.app.api.domain.vehicle.Vehicle;

import java.time.LocalDateTime;

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
                         LocalDateTime updatedAt) {

    public VehicleDto(Vehicle vehicle) {
        this(vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getFactoryYear(),
                vehicle.getModelYear(),
                vehicle.getAcquiredPrice(),
                vehicle.getCreatedAt(),
                vehicle.getUpdatedAt());
    }
}
