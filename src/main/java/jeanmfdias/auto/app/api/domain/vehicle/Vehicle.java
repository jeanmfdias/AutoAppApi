package jeanmfdias.auto.app.api.domain.vehicle;

import jakarta.persistence.*;
import jeanmfdias.auto.app.api.domain.order.Order;
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

}
