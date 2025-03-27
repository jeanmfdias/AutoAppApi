package jeanmfdias.auto.app.api.domain.vehicle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jeanmfdias.auto.app.api.domain.vehicle.Vehicle;

public record VehicleOdometerDto(String brand,

                                 String model,

                                 @JsonProperty("factory_year")
                                 Long factoryYear,

                                 @JsonProperty("model_year")
                                 Long modelYear,

                                 Long odometer) {

    public VehicleOdometerDto(Vehicle vehicle, Long odometer) {
        this(vehicle.getBrand(), vehicle.getModel(), vehicle.getFactoryYear(), vehicle.getModelYear(), odometer);
    }

}
