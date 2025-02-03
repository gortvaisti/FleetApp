package com.gortva.Fleet.repository;

import com.gortva.Fleet.model.enums.FuelType;
import com.gortva.Fleet.model.dao.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByFuelType(FuelType fuelType);

    List<Vehicle> findByPassengerCapacityGreaterThanEqual(int minCapacity);

    List<Vehicle> findByRangeKmGreaterThanEqual(int minRange);
}
