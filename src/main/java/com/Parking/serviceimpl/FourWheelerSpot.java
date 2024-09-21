package com.Parking.serviceimpl;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FourWheelerSpot extends ParkingSpot{
	
	public int price() {
		return 40;
	}

}
