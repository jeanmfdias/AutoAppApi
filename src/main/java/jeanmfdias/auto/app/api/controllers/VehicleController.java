package jeanmfdias.auto.app.api.controllers;

import jeanmfdias.auto.app.api.domain.vehicle.dto.VehicleDto;
import jeanmfdias.auto.app.api.domain.vehicle.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("{id}")
    public ResponseEntity<VehicleDto> getOneVehicle(@PathVariable Long id) {
        var vehicle = this.vehicleService.getOne(id);
        return ResponseEntity.ok(new VehicleDto(vehicle));
    }

}
