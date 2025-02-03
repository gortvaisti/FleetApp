package com.gortva.Fleet.controller;

import com.gortva.Fleet.service.TripPlannerService;
import com.gortva.Fleet.model.dto.TripSuggestion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;


@RestController
@RequestMapping("/trips")
@Tag(name = "Trip Planning", description = "Endpoints for trip planning and vehicle assignments")
public class TripPlannerController {

    private final TripPlannerService tripPlannerService;

    public TripPlannerController(TripPlannerService tripPlannerService) {
        this.tripPlannerService = tripPlannerService;
    }

    @Operation(
            summary = "Get trip suggestions",
            description = "Finds the best vehicle options based on the number of passengers and trip distance."
    )
    @GetMapping("/suggestions")
    public ResponseEntity<List<TripSuggestion>> getTripSuggestions(
            @Parameter(description = "Number of passengers for the trip", required = true) @RequestParam int passengers,
            @Parameter(description = "Trip distance in kilometers", required = true) @RequestParam int distance) {
        List<TripSuggestion> suggestions = tripPlannerService.findBestVehiclesForTrip(passengers, distance);
        return ResponseEntity.ok(suggestions);
    }
}
