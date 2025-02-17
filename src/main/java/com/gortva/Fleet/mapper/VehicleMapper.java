package com.gortva.Fleet.mapper;

import com.gortva.Fleet.model.dao.Vehicle;
import com.gortva.Fleet.model.dto.VehicleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "passengerCapacity", source = "passengerCapacity")
    @Mapping(target = "rangeKm", source = "rangeKm")
    @Mapping(target = "fuelType", source = "fuelType")
    VehicleDTO vehicleToDTO(Vehicle vehicle);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "passengerCapacity", source = "passengerCapacity")
    @Mapping(target = "rangeKm", source = "rangeKm")
    @Mapping(target = "fuelType", source = "fuelType")
    Vehicle dtoToVehicle(VehicleDTO vehicleDTO);

    List<VehicleDTO> toDTOList(List<Vehicle> vehicles);
}