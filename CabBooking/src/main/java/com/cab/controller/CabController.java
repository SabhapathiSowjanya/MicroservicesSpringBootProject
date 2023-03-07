package com.cab.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cab.entity.Cab;
import com.cab.entity.CabSearch;
import com.cab.exception.CabNotFoundException;
import com.cab.service.CabServiceImp;



@RestController
@RequestMapping("/cabBooking")
public class CabController {

	@Autowired
	CabServiceImp cabSer;
	

	@Autowired
	private RestTemplate restTemplate;
	
	private static final String CABADMIN_URL="http://CABADMIN/cabsearch/findbylocation";
	
	@PostMapping("/addCab")
	public ResponseEntity<String> addCabDetails(@RequestBody Cab cab)
	{
		Cab obj=cabSer.addCabDetails(cab);
		return new ResponseEntity<String>("Cab Id is "+obj.getCabId(),HttpStatus.OK);
	}
	
	@GetMapping("/getAllCabs")
	public ResponseEntity<List<Cab>> getDetails()
	{
		List<Cab> cabResponse = cabSer.getAllCabs();
		return new ResponseEntity<List<Cab>>(cabResponse,HttpStatus.OK);
	}
	
	@GetMapping("/getByCabId/{cabId}")
	public ResponseEntity<Cab> getUserId(@PathVariable("cabId") Integer cabId) {
		Optional<Cab> cab= cabSer.getByCabId(cabId);
		if (cab.isPresent()) {
			return new ResponseEntity<Cab>(cab.get(), HttpStatus.OK);
		}else
			throw new CabNotFoundException("Cab not exist with given id");
		
	}
	
	
	@DeleteMapping("/deleteAllCabs")
	public String deleteall() {
		return cabSer.deleteAllCabs();
	}
	
	@DeleteMapping("/deleteCab")
	public ResponseEntity<String> deleteExpenseById(@RequestParam("cabId") Integer cabId) {
		cabSer.deleteCabById(cabId);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	
	/*
	 * @GetMapping("/findbylocation/{location}") public CabSearch[]
	 * getByLocation(@PathVariable String location){ CabSearch[]
	 * cabLocation=restTemplate.getForObject(CABADMIN_URL+"/"+location,
	 * CabSearch[].class); return cabLocation; //return cabLocation;
	 * 
	 *     }
	 */
	
	
}
