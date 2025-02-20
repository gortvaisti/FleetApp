package com.gortva.Fleet.service;


import com.gortva.Fleet.mapper.VehicleMapper;
import com.gortva.Fleet.model.dao.Vehicle;
import com.gortva.Fleet.model.dto.TripSuggestionDTO;
import com.gortva.Fleet.model.dto.VehicleDTO;
import com.gortva.Fleet.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripPlannerServiceImpl implements TripPlannerService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    @Autowired
    public TripPlannerServiceImpl(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public List<TripSuggestionDTO> findBestVehiclesForTrip(int passengers, int distance) {
        List<Vehicle> availableVehicles = vehicleRepository.findByRangeKmGreaterThanEqual(distance);
        List<VehicleDTO> availableVehicleDTOs = vehicleMapper.toDTOList(availableVehicles);
        List<TripSuggestionDTO> suggestions = new ArrayList<>();

        for (VehicleDTO vehicleDTO : availableVehicleDTOs) {
            int vehiclesNeeded = (int) Math.ceil((double) passengers / vehicleDTO.getPassengerCapacity());
            double travelFee = calculateTravelFee(passengers, distance);
            double refuelCost = calculateRefuelCost(vehicleDTO, distance, vehiclesNeeded);
            double profit = travelFee - refuelCost;

            suggestions.add(new TripSuggestionDTO(vehicleDTO, vehiclesNeeded, travelFee, refuelCost, profit));
        }

        return suggestions;
    }

    private double calculateTravelFee(int passengers, int distance) {
        int travelMinutes = calculateTravelTime(distance);
        int halfHours = (int) Math.ceil(travelMinutes / 30.0);
        return (passengers * distance * 2) + (passengers * halfHours * 2);
    }

    private double calculateRefuelCost(VehicleDTO vehicle, int distance, int vehicleCount) {
        double costPerKm = switch (vehicle.getFuelType()) {
            case GASOLINE -> 2;
            case PURE_ELECTRIC -> 1;
            case MILD_HYBRID -> calculateHybridFuelCost(distance);
        };
        return costPerKm * distance * vehicleCount;
    }

    private double calculateHybridFuelCost(int distance) {
        int cityDistance = Math.min(distance, 50);
        int highwayDistance = Math.max(distance - 50, 0);
        int effectiveCityDistance = cityDistance / 2 + cityDistance % 2;
        return (effectiveCityDistance + highwayDistance) * 1.5;
    }

    private int calculateTravelTime(int distance) {
        int cityDistance = Math.min(distance, 50);
        int highwayDistance = Math.max(distance - 50, 0);
        return (cityDistance * 2) + highwayDistance;
    }
}
