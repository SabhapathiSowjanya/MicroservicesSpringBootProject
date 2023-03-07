package com.cab.service;

import java.util.List;
import java.util.Optional;

import com.cab.entity.CabSearch;

public interface CabSearchService {
    CabSearch addCabSearchDetails(CabSearch cabSearch);
	
	List<CabSearch> getAllCabs();
	
	Optional<CabSearch> getByAdminId(Integer adminId);
	
	String deleteAllCabs();
	
	String deleteCabByAdminId(Integer adminId);
	
	CabSearch findByLocation(String location);


}
