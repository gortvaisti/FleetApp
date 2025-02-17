package com.gortva.Fleet.mapper;

import com.gortva.Fleet.model.dao.Vehicle;
import com.gortva.Fleet.model.dto.VehicleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    VehicleDTO vehicleToDTO(Vehicle vehicle);

    Vehicle dtoToVehicle(VehicleDTO vehicleDTO);

    List<VehicleDTO> toDTOList(List<Vehicle> vehicles);
}