package jeanmfdias.auto.app.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jeanmfdias.auto.app.api.domain.vehicle.Vehicle;
import jeanmfdias.auto.app.api.domain.vehicle.dto.CreateVehicleDto;
import jeanmfdias.auto.app.api.domain.vehicle.dto.VehicleDto;
import jeanmfdias.auto.app.api.domain.vehicle.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @Transactional
    public ResponseEntity<VehicleDto> create(@RequestBody @Valid CreateVehicleDto dto) {
        var vehicle = this.vehicleService.save(dto);
        return ResponseEntity.ok(new VehicleDto(vehicle));
    }

    @GetMapping
    public ResponseEntity<Page<VehicleDto>> getAll(@PageableDefault(size = 10, sort = "model") Pageable pagination) {
        var page = this.vehicleService.getAll(pagination)
                .map(VehicleDto::new);
        return ResponseEntity.ok(page);
    }

}
