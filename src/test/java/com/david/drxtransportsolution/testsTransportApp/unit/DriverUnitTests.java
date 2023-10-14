package com.david.drxtransportsolution.testsTransportApp.unit;

import com.david.drxtransportsolution.controllers.DriverController;
import com.david.drxtransportsolution.entities.Driver;
import com.david.drxtransportsolution.services.DriverService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DriverUnitTests {

    @Mock
    private DriverService driverService;

    @InjectMocks
    private DriverController driverController;

    @Test
    void testGetDriverNotFound() {
        long driverId = 1L;
        Mockito.when(driverService.getDriverById(driverId)).thenReturn(null);

        ResponseEntity<Driver> response = driverController.getDriver(driverId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testDeleteDriver() {
        long driverId = 1L;
        Mockito.when(driverService.deleteDriver(driverId)).thenReturn(true);

        ResponseEntity<String> response = driverController.deleteDriver(driverId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testDeleteDriverNotFound() {
        long driverId = 1L;
        Mockito.when(driverService.deleteDriver(driverId)).thenReturn(false);

        ResponseEntity<String> response = driverController.deleteDriver(driverId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
