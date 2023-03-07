package com.cab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cab.entity.Cab;
import com.cab.repository.CabRepository;
import com.cab.service.CabServiceImp;


@SpringBootTest
class CabBookingApplicationTests {

	@Autowired 
	private CabServiceImp cabSer;
	
	@MockBean
	private CabRepository cabRepo;
	
	@Test
	public void getAllCabs() {
		Mockito.when(cabRepo.findAll()).thenReturn(Stream
		.of(new Cab(1,"Hyd",200,true),
				new Cab(2, "banglore",500,true))
		.collect(Collectors.toList()));
		assertEquals(2,cabSer.getAllCabs().size());
	}
	
	
	@Test
	public  void getByCabId() {
		Integer cabId = 1;
		Optional<Cab> u = Optional.ofNullable(new Cab(1,"banglore",500,true) );
		Mockito.when(cabRepo.findById(cabId))
				.thenReturn(Optional.ofNullable(new Cab(1,"banglore",500,true)));
		assertEquals(u.get().getCabId(), cabSer.getByCabId(cabId).get().getCabId());
	}
	/*
	 * @Test public void addCabDetails() { Cab cab=new Cab(1,"bngr",500,true);
	 * Mockito.when(cabRepo.save(cab)).thenReturn(cab);
	 * 
	 * assertEquals(cab,cabSer.addCabDetails(cab)); }
	 */
	
	
	  @Test 
	  public void deleteCabById() { 
		  Cab cab = new Cab(1, "bngr", 500, true); 
	      assertEquals("Deleted Successfully", cabSer.deleteCabById(cab.getCabId())); 
	  }
	 
	
	  @Test
	  public void testDeleteall() {
		assertEquals("All Cabs deleted", cabSer.deleteAllCabs());
	}
	 

}
