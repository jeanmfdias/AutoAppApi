package jeanmfdias.auto.app.api.domain.vehicle.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
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
                               @JsonAlias("factory_year")
                               Long factoryYear,

                               @Positive
                               @Min(Vehicle.MIN_FACTORY_YEAR)
                               @JsonAlias("model_year")
                               Long modelYear,

                               @Positive
                               @JsonAlias("acquired_price")
                               Double acquiredPrice) {
}
