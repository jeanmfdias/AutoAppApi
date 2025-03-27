package jeanmfdias.auto.app.api.domain.order.repositories;

import jeanmfdias.auto.app.api.domain.order.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    public Page<Order> findAll(Pageable pagination);

    public Page<Order> findAllByVehicleId(Long vehicleId, Pageable pagination);

}
