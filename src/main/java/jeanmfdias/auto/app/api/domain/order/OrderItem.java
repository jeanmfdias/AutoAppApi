package jeanmfdias.auto.app.api.domain.order;

import jakarta.persistence.*;
import jeanmfdias.auto.app.api.domain.order.dto.CreateOrderItemDto;
import jeanmfdias.auto.app.api.domain.order.dto.UpdateOrderItemDto;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private Type type;

    private Double value;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderItem(CreateOrderItemDto dto) {
        this.setDescription(dto.description());
        this.setType(dto.type());
        this.setValue(dto.value());
        this.setCreatedAt(LocalDate.now());
        this.setUpdatedAt(LocalDate.now());
    }

    public OrderItem(UpdateOrderItemDto dto) {
        this.setDescription(dto.description());
        this.setType(dto.type());
        this.setValue(dto.value());
        if (this.getCreatedAt() == null) {
            this.setCreatedAt(LocalDate.now());
        }
        this.setUpdatedAt(LocalDate.now());
    }

}
