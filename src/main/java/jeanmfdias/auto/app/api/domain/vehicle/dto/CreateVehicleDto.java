package jeanmfdias.auto.app.api.domain.vehicle.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CreateVehicleDto(@NotBlank
                               String brand,

                               @NotBlank
                               String model,

                               @Positive
                               @Min(1930)
                               Long factoryYear,

                               @Positive
                               @Min(1930)
                               Long modelYear,

                               @Positive
                               Double acquiredPrice) {
}
