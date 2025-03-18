package jeanmfdias.auto.app.api.domain.order;

import jakarta.persistence.*;
import jeanmfdias.auto.app.api.domain.order.dto.CreateOrderDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Double odometer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    public Order(CreateOrderDto dto) {
        List<OrderItem> orderItems = dto.items().stream()
                .map(OrderItem::new)
                .toList();
        orderItems.forEach(item -> item.setOrder(this));

        this.setOdometer(dto.odometer());
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.setItems(orderItems);
    }
}
