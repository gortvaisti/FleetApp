package com.gortva.Fleet.controller;

import com.gortva.Fleet.model.enums.FuelType;
import com.gortva.Fleet.model.dto.VehicleDTO;
import com.gortva.Fleet.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
@Tag(name = "Vehicles", description = "Endpoints for managing the fleet's vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Operation(summary = "Adds a new vehicle", description = "Creates a new vehicle and returns the created DTO.")
    @PostMapping
    public ResponseEntity<VehicleDTO> addVehicle(@Valid @RequestBody VehicleDTO vehicle) {
        VehicleDTO savedVehicle = vehicleService.addVehicle(vehicle);
        return ResponseEntity.created(URI.create("/vehicles/" + savedVehicle.getPassengerCapacity()))
                .body(savedVehicle);
    }

    @Operation(summary = "Retrieves all vehicles", description = "Returns a list of all vehicles in the fleet.")
    @GetMapping
    public List<VehicleDTO> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @Operation(summary = "Find a vehicle by ID", description = "Retrieves vehicle details based on its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(
            @Parameter(description = "ID of the vehicle") @PathVariable Long id) {
        return vehicleService.getVehicleById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a vehicle", description = "Deletes a vehicle based on its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(
            @Parameter(description = "ID of the vehicle to be deleted") @PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get vehicles by fuel type", description = "Retrieves all vehicles that match the given fuel type.")
    @GetMapping("/fuel/{fuelType}")
    public List<VehicleDTO> getVehiclesByFuelType(
            @Parameter(description = "Fuel type of the vehicle") @PathVariable FuelType fuelType) {
        return vehicleService.getVehiclesByFuelType(fuelType);
    }

    @Operation(summary = "Get vehicles by passenger capacity", description = "Finds vehicles with at least the specified passenger capacity.")
    @GetMapping("/capacity/{minCapacity}")
    public List<VehicleDTO> getVehiclesByPassengerCapacity(
            @Parameter(description = "Minimum passenger capacity") @PathVariable int minCapacity) {
        return vehicleService.getVehiclesByPassengerCapacity(minCapacity);
    }

    @Operation(summary = "Get vehicles by range", description = "Finds vehicles with at least the specified range in kilometers.")
    @GetMapping("/range/{minRange}")
    public List<VehicleDTO> getVehiclesByRange(
            @Parameter(description = "Minimum range in kilometers") @PathVariable int minRange) {
        return vehicleService.getVehiclesByRange(minRange);
    }
}
