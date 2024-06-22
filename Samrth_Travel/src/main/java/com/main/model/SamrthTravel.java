package com.main.model;



import java.util.Set;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class SamrthTravel {

	
	@Id
	private String busNumber;
	private String busAgencyName;
	private String busOwnerName;
	private String busDriverName;
	private String busCoDerivedName;
	private int busSeatingCapacity;
	private float busTicketPrice;
	private String fromLocation;
	private String toLocation;
	private String onBoardingTime;
	private String tropTime;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Seat> seats;

}
