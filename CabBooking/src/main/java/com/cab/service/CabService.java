package com.cab.service;

import java.util.List;
import java.util.Optional;

import com.cab.entity.Cab;
import com.cab.entity.CabSearch;

public interface CabService {
	
	Cab addCabDetails(Cab cab);
	
	List<Cab> getAllCabs();
	
	Optional<Cab> getByCabId(Integer cabId);
	
	String deleteAllCabs();
	
	String deleteCabById(Integer cabId);

}
