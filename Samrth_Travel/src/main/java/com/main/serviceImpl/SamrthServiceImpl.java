package com.main.serviceImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.exception.NullException;
import com.main.exception.SeatBooked;
import com.main.exception.SeatIsNotNotAvailable;
import com.main.model.Passenger;
import com.main.model.SamrthTravel;
import com.main.model.Seat;
import com.main.repository.SamrthRepository;
import com.main.service.SamrthService;

@Service
public class SamrthServiceImpl implements SamrthService{

	
	@Autowired SamrthRepository travelRepository;

	@Override
	public SamrthTravel postSamrthTravel(SamrthTravel samrthTravel) {
		
		Set<Seat> listSeat = new LinkedHashSet<Seat>();
		
		for(int i=1 ; i<=samrthTravel.getBusSeatingCapacity() ; i++)
		{
			Seat seat = new Seat();
			if(i>=20)
			{
				seat.setSeatNumber("U"+i);
				seat.setSeatStatus("Available");
			}
			else
			{
				seat.setSeatId(i);
				seat.setSeatNumber("L"+i);
				seat.setSeatStatus("Available");
			}
			listSeat.add(seat);
		}
		
		samrthTravel.setSeats(listSeat);
		
		return travelRepository.save(samrthTravel);
		
		
	}

	@Override
	public SamrthTravel update(Passenger passenger, String busNumber,int seatId) {
		
	
		SamrthTravel sam = travelRepository.findByBusNumber(busNumber);

		if(sam!=null)
		{
			Set<Seat> seat = sam.getSeats();
			
			boolean seatFound = false;
			
			for(Seat seats : seat)
			{
				
				if(seats.getSeatId()==seatId)
				{
					seatFound=true;
					if(!seats.getSeatStatus().equals("Booked"))
					{
						 seats.setSeatStatus("Booked");
		                 seats.setPassenger(passenger);
					}
					else
					{
						throw new SeatBooked("Seat is already booked!!!!");
					}
					
				}
				
				
			}
			if(seatFound==false)
			{
				throw new SeatIsNotNotAvailable("Seat is not Available!!!!");
			}
		}
		else
		{
			throw new NullException("Bus is not Available !!!");
		}
		
		return travelRepository.save(sam);
	}

}
