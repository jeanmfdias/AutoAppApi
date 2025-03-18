package jeanmfdias.auto.app.api.domain.order.repositories;

import jeanmfdias.auto.app.api.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
