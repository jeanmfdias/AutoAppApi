package jeanmfdias.auto.app.api.domain.vehicle.dto;

import jeanmfdias.auto.app.api.domain.order.dto.OrderDto;
import jeanmfdias.auto.app.api.domain.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.List;

public record VehicleDto(Long id,
                         String brand,
                         String model,
                         Long factoryYear,
                         Long modelYear,
                         Double acquiredPrice,
                         LocalDateTime createdAt,
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
                vehicle.getOrders().stream()
                        .map(OrderDto::new)
                        .toList());
    }

}
