package com.cab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cab.entity.CabSearch;

@Repository
public interface CabSearchRepository  extends JpaRepository<CabSearch,Integer> {

	CabSearch findByLocation(String location);

}
