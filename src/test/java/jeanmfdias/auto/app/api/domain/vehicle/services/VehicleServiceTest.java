package jeanmfdias.auto.app.api.domain.vehicle.services;

import jeanmfdias.auto.app.api.domain.vehicle.repositories.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {

    @InjectMocks
    private VehicleService vehicleService;

    @Mock
    private VehicleRepository vehicleRepository;

    @Captor
    private ArgumentCaptor<Long> longCaptor;

    @Test
    void testShouldReturnOneVehicle() {
        // ARRANGE
        Long id = 1L;

        // ACT
        this.vehicleService.getOne(id);

        //ASSERT
        then(this.vehicleRepository).should().getReferenceById(longCaptor.capture());
        assertEquals(id, longCaptor.getValue());
    }
}