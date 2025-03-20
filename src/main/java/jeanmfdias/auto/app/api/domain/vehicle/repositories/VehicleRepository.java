package jeanmfdias.auto.app.api.domain.vehicle.repositories;

import jeanmfdias.auto.app.api.domain.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
