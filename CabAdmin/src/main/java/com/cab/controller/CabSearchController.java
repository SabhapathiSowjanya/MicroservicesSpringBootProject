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

import com.cab.entity.CabSearch;
import com.cab.exception.CabNotFoundException;
import com.cab.service.CabSearchServiceImp;


@RestController
@RequestMapping("/cabsearch")
public class CabSearchController {
	
	@Autowired
	CabSearchServiceImp cabSearchSer;
	
	@PostMapping("/addCab")
	public ResponseEntity<String> addCabDetails(@RequestBody CabSearch cab)
	{
		CabSearch cabSearch=cabSearchSer.addCabSearchDetails(cab);
		return new ResponseEntity<String>("Admin Id is "+cabSearch.getAdminId(),HttpStatus.OK);
	}
	
	@GetMapping("/getAllCabs")
	public ResponseEntity<List<CabSearch>> getDetails()
	{
		List<CabSearch> cabResponse =cabSearchSer.getAllCabs();
		return new ResponseEntity<List<CabSearch>>(cabResponse,HttpStatus.OK);
	}
	
	@GetMapping("/getByAdminId/{adminId}")
	public ResponseEntity<CabSearch> getUserId(@PathVariable("adminId") Integer adminId) {
		Optional<CabSearch> cab= cabSearchSer.getByAdminId(adminId);
		if (cab.isPresent()) {
			return new ResponseEntity<CabSearch>(cab.get(), HttpStatus.OK);
		}else
			throw new CabNotFoundException("AdminId not exist with given id");
		
	}
	
	
	@DeleteMapping("/deleteAllCabs")
	public String deleteall() {
		return cabSearchSer.deleteAllCabs();
	}
	
	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<String> deleteExpenseById(@RequestParam("adminId") Integer adminId) {
		cabSearchSer.deleteCabByAdminId(adminId);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	
	@GetMapping("/findbylocation/{location}")
	public CabSearch getByLocation(@PathVariable String location){
		return cabSearchSer.findByLocation(location);
		//return cabSearchSer.findByOriginAndDestination(origin,destination);    
	}

}
