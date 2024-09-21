package com.Parking.serviceimpl;

import org.springframework.stereotype.Service;

import com.Parking.vo.TYPE;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ParkingManagerImpl implements ParkingManager {
	
	ParkingSpotManager twoWheelerManager=new TwoWheelerParkingSpotManager();
	ParkingSpotManager fourWheelerManager=new FourWheelerParkingSpotManager();
	
	
	
	public ParkingSpotManager getParkingManager(TYPE type){
		if(type.equals(TYPE.TWO_WHEELER)) {
			return twoWheelerManager;
		}else {
			return fourWheelerManager;
		}
		
	}
	

}
