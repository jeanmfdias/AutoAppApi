package jeanmfdias.auto.app.api.domain.vehicle.services;

import jeanmfdias.auto.app.api.domain.vehicle.Vehicle;
import jeanmfdias.auto.app.api.domain.vehicle.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle getOne(Long id) {
        return this.vehicleRepository.getReferenceById(id);
    }

}
