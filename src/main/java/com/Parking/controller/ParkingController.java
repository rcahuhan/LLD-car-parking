package com.Parking.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Parking.serviceimpl.ParkingManager;
import com.Parking.serviceimpl.ParkingManagerImpl;
import com.Parking.serviceimpl.ParkingSpot;
import com.Parking.serviceimpl.ParkingSpotManager;
import com.Parking.serviceimpl.Ticket;
import com.Parking.vo.TYPE;
import com.Parking.vo.Vehicle;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("parking")
@Slf4j
public class ParkingController {
	
	private final ParkingManager parkingManager;
	
	private ParkingSpotManager parkingSpotManager;
	
	public ParkingController(ParkingManagerImpl parkingManager) {
		// TODO Auto-generated constructor stub
		this.parkingManager=parkingManager;
	}
	
	
	@PostMapping("/book")
	public Ticket bookParkingSpotForVechile(@RequestBody Vehicle vehicle) {
		Ticket ticket = null;
		try {
		parkingSpotManager=parkingManager.getParkingManager(vehicle.getType());
		ParkingSpot parkingSpot=parkingSpotManager.findParkingSpace();
		parkingSpot.setVehicle(vehicle);
		parkingSpotManager.parkVehicle(parkingSpot);
		System.out.println();
		ticket=Ticket.builder().currentTime(LocalDateTime.now()).parkingSpot(parkingSpot).build();
		}
		catch (Exception e) {
			// TODO: handle exception
			log.error("Exception while performing the work {}",e.getMessage(),e);
		}
		return ticket;
	}
	
	@PostMapping("/exit")
	public int exitSpot(@RequestBody Ticket ticket) {
		int price=0;
		try {
		parkingSpotManager=parkingManager.getParkingManager(ticket.getParkingSpot().getVehicle().getType());
		ParkingSpot parkingSpot=parkingSpotManager.findParkingSpace();
		parkingSpotManager.removeVehicleFromSpot(parkingSpot);		
		price=(int) (calculateprice(ticket)*ticket.getParkingSpot().getPrice());
		}
		catch (Exception e) {
			// TODO: handle exception
			log.error("Exception while performing the work {}",e.getMessage(),e);
		}
		return price;
	}
	
	Long calculateprice(Ticket ticket) {
		
		Duration duration = Duration.between( ticket.getCurrentTime(),LocalDateTime.now());
        // Get the total hours between the two times (including day difference)
        long totalHours = duration.toHours();
        long totalMinutes = duration.toMinutes() % 60;
        long sec=duration.toMillis();
        log.error("hours {} minute {} sec {}",totalHours,totalMinutes,sec);
        if(totalMinutes>0 || sec>0 ) {
        	totalHours++;
        }
        return totalHours;
		
	}
	
	

}
