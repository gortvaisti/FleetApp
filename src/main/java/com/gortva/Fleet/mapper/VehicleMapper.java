package com.gortva.Fleet.mapper;

import com.gortva.Fleet.model.dao.Vehicle;
import com.gortva.Fleet.model.dto.VehicleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    @Mapping(source = "passengerCapacity", target = "passengerCapacity")
    @Mapping(source = "rangeKm", target = "rangeKm")
    @Mapping(source = "fuelType", target = "fuelType")
    VehicleDTO vehicleToDTO(Vehicle vehicle);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "passengerCapacity", target = "passengerCapacity")
    @Mapping(source = "rangeKm", target = "rangeKm")
    @Mapping(source = "fuelType", target = "fuelType")
    Vehicle dtoToVehicle(VehicleDTO vehicleDTO);

    List<VehicleDTO> toDTOList(List<Vehicle> vehicles);
}