package com.Parking.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ParkingSpot {
	
	private int id;
	private Boolean isEmpty;
	private Vehicle vehicle;
	private int price;
	
	public void parkVehicle(Vehicle v) {
		this.vehicle=v;
		this.isEmpty=false;
	}
	
	public void freeSpace() {
		this.isEmpty=true;
		vehicle=null;
	}
	
	

}
