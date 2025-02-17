package com.gortva.Fleet.model.dto;

import com.gortva.Fleet.model.enums.FuelType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Objects;

public class VehicleDTO {
    private Long id;

    @NotNull(message = "Passenger capacity is required")
    @Min(value = 1, message = "Passenger capacity must be at least 1")
    private Integer passengerCapacity;

    @NotNull(message = "Range (km) is required")
    @Positive(message = "Range (km) must be greater than 0")
    private Integer rangeKm;

    @NotNull(message = "Fuel type is required")
    private FuelType fuelType;

    // 📌 Getterek és setterek
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Integer getRangeKm() {
        return rangeKm;
    }

    public void setRangeKm(Integer rangeKm) {
        this.rangeKm = rangeKm;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    // toString()
    @Override
    public String toString() {
        return "VehicleDTO{" +
                "passengerCapacity=" + passengerCapacity +
                ", rangeKm=" + rangeKm +
                ", fuelType=" + fuelType +
                '}';
    }

    // equals and hashCode (Optional)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleDTO that = (VehicleDTO) o;
        return Objects.equals(passengerCapacity, that.passengerCapacity) &&
                Objects.equals(rangeKm, that.rangeKm) &&
                fuelType == that.fuelType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerCapacity, rangeKm, fuelType);
    }
}
