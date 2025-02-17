package com.gortva.Fleet.model.dao;

import com.gortva.Fleet.model.enums.FuelType;
import jakarta.persistence.*;


@Entity
@Table(name = "vehicles")
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

    // 📌 Üres konstruktor szükséges a JPA számára
    public Vehicle() {
    }

    // 📌 Konstruktor az összes mező inicializálására
    public Vehicle(int passengerCapacity, int rangeKm, FuelType fuelType) {
        this.passengerCapacity = passengerCapacity;
        this.rangeKm = rangeKm;
        this.fuelType = fuelType;
    }

    // 📌 Getterek
    public Long getId() {
        return id;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getRangeKm() {
        return rangeKm;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    // 📌 Setterek

    public void setId(Long id) {
        this.id = id;
    }
    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public void setRangeKm(int rangeKm) {
        this.rangeKm = rangeKm;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    // 📌 toString() metódus
    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", passengerCapacity=" + passengerCapacity +
                ", rangeKm=" + rangeKm +
                ", fuelType=" + fuelType +
                '}';
    }

    // 📌 equals() és hashCode() az objektumok összehasonlításához
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return passengerCapacity == vehicle.passengerCapacity &&
                rangeKm == vehicle.rangeKm &&
                fuelType == vehicle.fuelType &&
                id.equals(vehicle.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, passengerCapacity, rangeKm, fuelType);
    }
}
