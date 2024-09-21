package com.Parking.serviceimpl;

import java.util.Map;
import java.util.TreeMap;

public class TwoWheelerParkingSpotManager extends ParkingSpotManager {
    
    private static TreeMap<Integer, ParkingSpot> parkingSpots = new TreeMap<>();

    // Initialize parking spots for two-wheelers
    void init() {
        // Initialize parking spots with key as a String representation of spot number
        for (int i = 1; i <= 20; i++) {
            parkingSpots.put(i, new ParkingSpot(i, true, null, 20));
        }
    }

    // Constructor
    TwoWheelerParkingSpotManager() {
        init();  // Call the init method to populate parking spots
        super.setParkingSpots(parkingSpots);  // Pass the parking spots to the superclass (assuming a setter method)
    }
}
