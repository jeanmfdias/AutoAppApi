package jeanmfdias.auto.app.api.domain.vehicle.services;

import jeanmfdias.auto.app.api.domain.vehicle.Vehicle;
import jeanmfdias.auto.app.api.domain.vehicle.dto.CreateVehicleDto;
import jeanmfdias.auto.app.api.domain.vehicle.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle getOne(Long id) {
        return this.vehicleRepository.getReferenceById(id);
    }

    public Vehicle save(CreateVehicleDto createVehicleDto) {
        var vehicle = new Vehicle(createVehicleDto);
        this.vehicleRepository.save(vehicle);
        return vehicle;
    }

    public Page<Vehicle> getAll(Pageable pagination) {
        return this.vehicleRepository.findAll(pagination);
    }

    public Boolean delete(Long id) {
        var vehicle = this.vehicleRepository.getReferenceById(id);
        this.vehicleRepository.delete(vehicle);
        if (this.vehicleRepository.existsById(id)) {
            return true;
        }
        return false;
    }

}
