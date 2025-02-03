package com.gortva.Fleet.model.dao;

import com.gortva.Fleet.model.enums.FuelType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles")
@NoArgsConstructor(force = true)
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "passenger_capacity", nullable = false)
    private int passengerCapacity;

    @Column(name = "range_km", nullable = false)
    private int rangeKm;

    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type", nullable = false)
    private FuelType fuelType;
}
