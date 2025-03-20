package jeanmfdias.auto.app.api.domain.vehicle.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jeanmfdias.auto.app.api.domain.vehicle.Vehicle;

public record CreateVehicleDto(@NotBlank
                               String brand,

                               @NotBlank
                               String model,

                               @Positive
                               @Min(Vehicle.MIN_FACTORY_YEAR)
                               Long factoryYear,

                               @Positive
                               @Min(Vehicle.MIN_FACTORY_YEAR)
                               Long modelYear,

                               @Positive
                               Double acquiredPrice) {
}
