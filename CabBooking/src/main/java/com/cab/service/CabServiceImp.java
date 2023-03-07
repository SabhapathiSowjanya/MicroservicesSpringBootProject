package com.cab.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cab.entity.Cab;
import com.cab.entity.CabSearch;
import com.cab.repository.CabRepository;


@Service
public class CabServiceImp implements CabService{

	@Autowired
	CabRepository cabRepo;
	
	
	//CabSearch cabSearch;
	
	@Autowired
	private RestTemplate restTemplate;
	//private static final String CABADMIN_URL="http://CABADMIN/cabsearch/findbylocation";
	//CabAdmin cabAdmin=restTemplate.getForObject("http://CABADMIN/cabsearch/findbylocation"+flightdata.getFlightNumber()+"/"+flightdata.getBookingDate(),CabAdmin.class);
	
	@Override
	public Cab addCabDetails(Cab cab) {
		
		cab.setBooked(true);
		CabSearch cabAdmin=restTemplate.getForObject("http://CABADMIN/cabsearch/findbylocation/"+cab.getLocation(),CabSearch.class);
		if(cabAdmin.getLocation()==cab.getLocation()) {
			if(cabAdmin.getType()=="auto") {
				cab.setPrice(cabAdmin.getPrice());
			}
			else if(cabAdmin.getType()=="mini"){
				cab.setPrice(cabAdmin.getPrice());
			}
		}
		return cabRepo.save(cab);
	}
	
	@Override
	public List<Cab> getAllCabs(){
		return (List<Cab>)cabRepo.findAll();
	}
	
	@Override
	public Optional<Cab> getByCabId(Integer cabId){
			return cabRepo.findById(cabId);
	}
	
	@Override
	public String deleteAllCabs() {
		cabRepo.deleteAll();
		return "All Cabs deleted";
	}

	@Override
	public String deleteCabById(Integer cabId) {
		cabRepo.deleteById(cabId);	
		return "Deleted Successfully";
	}
	
	
	
	
}
