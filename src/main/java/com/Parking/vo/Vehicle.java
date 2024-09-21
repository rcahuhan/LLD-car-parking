package com.Parking.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Vehicle {
	
	private int vehicleNo;
    @JsonProperty("TYPE")
	private TYPE type;

}
