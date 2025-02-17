package com.gortva.Fleet.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


public class TripSuggestion {

    private VehicleDTO vehicle;
    private int vehiclesNeeded;
    private double travelFee;
    private double refuelCost;
    private double profit;

    // No-args constructor
    public TripSuggestion() {}

    // All-args constructor
    public TripSuggestion(VehicleDTO vehicle, int vehiclesNeeded, double travelFee, double refuelCost, double profit) {
        this.vehicle = vehicle;
        this.vehiclesNeeded = vehiclesNeeded;
        this.travelFee = travelFee;
        this.refuelCost = refuelCost;
        this.profit = profit;
    }

    // Getters and Setters
    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }

    public int getVehiclesNeeded() {
        return vehiclesNeeded;
    }

    public void setVehiclesNeeded(int vehiclesNeeded) {
        this.vehiclesNeeded = vehiclesNeeded;
    }

    public double getTravelFee() {
        return travelFee;
    }

    public void setTravelFee(double travelFee) {
        this.travelFee = travelFee;
    }

    public double getRefuelCost() {
        return refuelCost;
    }

    public void setRefuelCost(double refuelCost) {
        this.refuelCost = refuelCost;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    // toString()
    @Override
    public String toString() {
        return "TripSuggestion{" +
                "vehicle=" + vehicle +
                ", vehiclesNeeded=" + vehiclesNeeded +
                ", travelFee=" + travelFee +
                ", refuelCost=" + refuelCost +
                ", profit=" + profit +
                '}';
    }

    // equals and hashCode (Optional)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripSuggestion that = (TripSuggestion) o;
        return vehiclesNeeded == that.vehiclesNeeded &&
                Double.compare(that.travelFee, travelFee) == 0 &&
                Double.compare(that.refuelCost, refuelCost) == 0 &&
                Double.compare(that.profit, profit) == 0 &&
                Objects.equals(vehicle, that.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicle, vehiclesNeeded, travelFee, refuelCost, profit);
    }
}