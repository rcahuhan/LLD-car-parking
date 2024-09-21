package com.Parking.serviceimpl;

import com.Parking.vo.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpot {
	
	@JsonProperty("locationId")
	private int id;
	@JsonIgnore
	private Boolean isEmpty;
	@JsonProperty("Your Vehicle Details")
	private Vehicle vehicle;
	@JsonProperty("Cost Per Hour")
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
