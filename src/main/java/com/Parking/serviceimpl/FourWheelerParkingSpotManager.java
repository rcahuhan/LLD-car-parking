package com.Parking.serviceimpl;

import java.util.TreeMap;

public class FourWheelerParkingSpotManager extends ParkingSpotManager {
	
	 private static TreeMap<Integer, ParkingSpot> parkingSpots = new TreeMap<>();

	    // Initialize parking spots for two-wheelers
	    void init() {
	        // Initialize parking spots with key as a String representation of spot number
	        for (int i = 1; i <= 40; i++) {
	            parkingSpots.put(i, new ParkingSpot(i, true, null, 20));
	        }
	    }

	    // Constructor
	    FourWheelerParkingSpotManager() {
	        init();  // Call the init method to populate parking spots
	        super.setParkingSpots(parkingSpots);  // Pass the parking spots to the superclass (assuming a setter method)
	    }

}
