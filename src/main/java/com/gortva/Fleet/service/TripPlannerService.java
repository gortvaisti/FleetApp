package com.gortva.Fleet.service;

import com.gortva.Fleet.model.dto.TripSuggestionDTO;
import java.util.List;

public interface TripPlannerService {
    List<TripSuggestionDTO> findBestVehiclesForTrip(int passengers, int distance);
}
