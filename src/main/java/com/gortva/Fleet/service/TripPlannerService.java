package com.gortva.Fleet.service;

import com.gortva.Fleet.model.dto.TripSuggestion;
import java.util.List;

public interface TripPlannerService {
    List<TripSuggestion> findBestVehiclesForTrip(int passengers, int distance);
}
