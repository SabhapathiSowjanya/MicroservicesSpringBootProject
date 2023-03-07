package com.cab.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.entity.CabSearch;
import com.cab.repository.CabSearchRepository;

@Service
public class CabSearchServiceImp implements CabSearchService {

	@Autowired
	CabSearchRepository cabSearchRepo;

	@Override
	public CabSearch addCabSearchDetails(CabSearch cabSearch) {
		return cabSearchRepo.save(cabSearch);
		
	}

	@Override
	public List<CabSearch> getAllCabs() {
		return (List<CabSearch>)cabSearchRepo.findAll();
	}

	@Override
	public Optional<CabSearch> getByAdminId(Integer adminId) {
		return cabSearchRepo.findById(adminId);
	}

	@Override
	public String deleteAllCabs() {
		cabSearchRepo.deleteAll();
		return "All Cabs deleted";
	}

	@Override
	public String deleteCabByAdminId(Integer adminId) {
		cabSearchRepo.deleteById(adminId);	
		return "Deleted Successfully";
	}
	
	@Override
	public CabSearch findByLocation(String location) {
			return cabSearchRepo.findByLocation(location);
	}
	
}

