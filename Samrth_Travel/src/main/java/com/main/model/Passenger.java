package com.main.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Entity
@Setter
@Getter
public class Passenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int passengerId;
	private String passengerName;
	private String passengerAge;
	private String passengerGender;
	private String passengerContactNo;
	private String pickUpPoint;
	private String droppoint;

}
