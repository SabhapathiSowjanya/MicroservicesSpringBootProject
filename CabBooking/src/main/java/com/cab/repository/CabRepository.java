package com.cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cab.entity.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab,Integer>{
	

}
