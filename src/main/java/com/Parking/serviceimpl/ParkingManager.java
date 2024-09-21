package com.Parking.serviceimpl;


import com.Parking.vo.TYPE;


public interface ParkingManager {
	public ParkingSpotManager getParkingManager(TYPE type);

}
