package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Passenger;
import com.main.model.SamrthTravel;
import com.main.service.SamrthService;


@RestController
public class SamrthController {
	
	
	@Autowired 
	SamrthService samrthService;
	
	
    @PostMapping("/travel")
    public ResponseEntity<SamrthTravel> postSamrthTravel(@RequestBody SamrthTravel samrthTravel) 
    {
        SamrthTravel samrthTravel1 = samrthService.postSamrthTravel(samrthTravel);
        return new ResponseEntity<>(samrthTravel1, HttpStatus.CREATED);
    }
    
    @PutMapping("/travel/{busNumber}/{seatId}")
    public ResponseEntity<SamrthTravel> addPassenger(@RequestBody Passenger passenger, @PathVariable String busNumber, @PathVariable int seatId)
    {
    	SamrthTravel s = samrthService.update(passenger,busNumber,seatId);
    	
    	return new ResponseEntity<>(s,HttpStatus.OK);
    }


}
