package com.gortva.Fleet.service;

import com.gortva.Fleet.model.enums.FuelType;
import com.gortva.Fleet.model.dto.VehicleDTO;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    VehicleDTO addVehicle(VehicleDTO vehicleDTO);
    List<VehicleDTO> getAllVehicles();
    Optional<VehicleDTO> getVehicleById(Long id);
    void deleteVehicle(Long id);
    List<VehicleDTO> getVehiclesByFuelType(FuelType fuelType);
    List<VehicleDTO> getVehiclesByPassengerCapacity(int minCapacity);
    List<VehicleDTO> getVehiclesByRange(int minRange);
}