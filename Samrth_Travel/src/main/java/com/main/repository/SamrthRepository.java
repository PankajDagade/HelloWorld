package com.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.main.model.Passenger;
import com.main.model.SamrthTravel;

public interface SamrthRepository extends CrudRepository<SamrthTravel, String>{

	public SamrthTravel findByBusNumber(String busNumber);

	public SamrthTravel save(Passenger passenger);

	

	
	

}
