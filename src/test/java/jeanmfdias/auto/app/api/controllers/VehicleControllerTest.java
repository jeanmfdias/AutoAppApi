package jeanmfdias.auto.app.api.controllers;

import jeanmfdias.auto.app.api.domain.vehicle.Vehicle;
import jeanmfdias.auto.app.api.domain.vehicle.services.VehicleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class VehicleControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private VehicleService vehicleService;

    @Test
    void testShouldReturnStatusCode200() throws Exception {
        // ARRANGE
        var vehicle = new Vehicle();
        when(vehicleService.getOne(1L)).thenReturn(vehicle);

        // ACT
        var response = mvc.perform(get("/vehicles/1"))
                .andReturn()
                .getResponse();

        // ASSERT
        assertEquals(200, response.getStatus());
    }

    @Test
    void testShouldReturnStatusCode404() throws Exception {
        // ARRANGE

        // ACT
        var response = mvc.perform(get("/vehicles/1"))
                .andReturn()
                .getResponse();

        // ASSERT
        assertEquals(404, response.getStatus());
    }
}