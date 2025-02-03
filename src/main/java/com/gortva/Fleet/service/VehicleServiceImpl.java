package com.gortva.Fleet.service;

import com.gortva.Fleet.mapper.VehicleMapper;
import com.gortva.Fleet.model.dto.VehicleDTO;
import com.gortva.Fleet.model.dao.Vehicle;
import com.gortva.Fleet.model.enums.FuelType;
import com.gortva.Fleet.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public VehicleDTO addVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleMapper.dtoToVehicle(vehicleDTO);
        vehicle = vehicleRepository.save(vehicle);
        return vehicleMapper.vehicleToDTO(vehicle);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(vehicleMapper::vehicleToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<VehicleDTO> getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .map(vehicleMapper::vehicleToDTO);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public List<VehicleDTO> getVehiclesByFuelType(FuelType fuelType) {
        return vehicleRepository.findByFuelType(fuelType)
                .stream()
                .map(vehicleMapper::vehicleToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> getVehiclesByPassengerCapacity(int minCapacity) {
        return vehicleRepository.findByPassengerCapacityGreaterThanEqual(minCapacity)
                .stream()
                .map(vehicleMapper::vehicleToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> getVehiclesByRange(int minRange) {
        return vehicleRepository.findByRangeKmGreaterThanEqual(minRange)
                .stream()
                .map(vehicleMapper::vehicleToDTO)
                .collect(Collectors.toList());
    }
}
