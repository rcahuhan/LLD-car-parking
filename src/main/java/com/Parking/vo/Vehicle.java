package com.Parking.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Vehicle {
	
	private int vehicleNo;
	private TYPE type;

}
