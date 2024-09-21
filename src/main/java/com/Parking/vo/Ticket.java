package com.Parking.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Ticket {
	
	private String entryTime;
	private TYPE type;
		
	

}
