package jeanmfdias.auto.app.api.domain.order.repositories;

import jeanmfdias.auto.app.api.domain.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
