package com.main.service;

import com.main.model.Passenger;
import com.main.model.SamrthTravel;

public interface SamrthService {

	public SamrthTravel postSamrthTravel(SamrthTravel samrthTravel);

	

	public SamrthTravel update(Passenger passenger, String busNumber, int seatId);

}
