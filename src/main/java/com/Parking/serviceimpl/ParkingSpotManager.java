package com.Parking.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ParkingSpotManager {
	
	TreeMap<Integer,ParkingSpot> parkingSpots;
	
	public ParkingSpotManager setParkingSpots(TreeMap<Integer,ParkingSpot> mapOfParkingIdAndSpot) {
		this.parkingSpots=mapOfParkingIdAndSpot;
		return this;
	}
	
	public ParkingSpot findParkingSpace() {
		for (Map.Entry<Integer, ParkingSpot> entry : parkingSpots.entrySet()) {
            ParkingSpot spot = entry.getValue();
            // Check if the spot is empty
            if (spot.getIsEmpty()) {
                return spot; // Return the first empty parking spot found
            }
        }
		return null;
	
	}
	
	
	public void addParkingSpace(ParkingSpot parkingSpot) {
		parkingSpots.put(parkingSpot.getId(), parkingSpot);
		log.info("Parking spot added sucessfully with id {}",parkingSpot.getId());;
	}
	
	public void removeParkingSpace(ParkingSpot parkingSpot) {
		parkingSpots.remove(parkingSpot.getId());
		log.info("Parking spot sucessfully removed with id {}",parkingSpot.getId());;
	}
	
	public ParkingSpot parkVehicle(ParkingSpot parkingSpot) {
		parkingSpot.setIsEmpty(false);
		parkingSpots.put(parkingSpot.getId(), parkingSpot);
		return parkingSpot;
	}
	
	public void removeVehicleFromSpot(ParkingSpot parkingSpot) {
		parkingSpot.setIsEmpty(true);
		parkingSpots.put(parkingSpot.getId(), parkingSpot);
	}

	
}
