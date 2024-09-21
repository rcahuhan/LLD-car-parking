package com.Parking.serviceimpl;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.Parking.vo.Vehicle;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class Ticket {
	
    private LocalDateTime currentTime;
    private ParkingSpot parkingSpot;
    
}
