package jeanmfdias.auto.app.api.domain.vehicle;

import jakarta.persistence.*;
import jeanmfdias.auto.app.api.domain.order.Order;
import jeanmfdias.auto.app.api.domain.vehicle.dto.CreateVehicleDto;
import jeanmfdias.auto.app.api.domain.vehicle.dto.UpdateVehicleDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private Long factoryYear;

    private Long modelYear;

    private Double acquiredPrice;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Order> orders;

    @Transient
    public static final long MIN_FACTORY_YEAR = 1930;

    public Vehicle(CreateVehicleDto dto) {
        this.setBrand(dto.brand());
        this.setModel(dto.model());
        this.setAcquiredPrice(dto.acquiredPrice());
        this.setFactoryYear(dto.factoryYear());
        this.setModelYear(dto.modelYear());
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }

    public Vehicle(UpdateVehicleDto dto) {
        if (!dto.brand().isBlank()) {
            this.setBrand(dto.brand());
        }
        if (!dto.model().isBlank()) {
            this.setModel(dto.model());
        }
        if (dto.factoryYear() >= MIN_FACTORY_YEAR) {
            this.setFactoryYear(dto.factoryYear());
        }
        if (dto.modelYear() >= MIN_FACTORY_YEAR) {
            this.setModelYear(dto.modelYear());
        }
        this.setUpdatedAt(LocalDateTime.now());
    }

}
