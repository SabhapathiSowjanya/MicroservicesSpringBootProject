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

import com.cab.entity.CabSearch;
import com.cab.repository.CabSearchRepository;
import com.cab.service.CabSearchService;


@SpringBootTest
class CabSearchingApplicationTests {
	
	@Autowired
	private CabSearchService cabSearchSer;

	@MockBean
	private CabSearchRepository cabRepo;

	@Test
	public void addCabSearchDetails() {
		CabSearch cabsearch = new CabSearch(1, "bng", "mini",342 );
		Mockito.when(cabRepo.save(cabsearch)).thenReturn(cabsearch);
		assertEquals(cabsearch, cabSearchSer.addCabSearchDetails(cabsearch));
	}

	@Test
	public void getAllCabs() {
		Mockito.when(cabRepo.findAll()).thenReturn(Stream
				.of(new CabSearch(1, "bng", "mini",342), new CabSearch(2,"hyd","auto",123))
				.collect(Collectors.toList()));
		assertEquals(2, cabSearchSer.getAllCabs().size());
	}

	@Test
	public void getByAdminId() {
		Integer adminId = 1;
		Optional<CabSearch> u = Optional.ofNullable(new CabSearch(1, "bng", "mini",342));
		Mockito.when(cabRepo.findById(adminId))
				.thenReturn(Optional.ofNullable(new CabSearch(1, "bng", "mini",342)));
		assertEquals(u.get().getAdminId(), cabSearchSer.getByAdminId(adminId).get().getAdminId());
	}

	@Test
	public void deleteCabByAdminId() {
		CabSearch cab = new CabSearch(1, "bng", "mini",342);
		assertEquals("Deleted Successfully", cabSearchSer.deleteCabByAdminId((cab.getAdminId())));
	}

	@Test
	public void deleteAllCabs() {
		assertEquals("All Users deleted", cabSearchSer.deleteAllCabs());
	}
	 
}
