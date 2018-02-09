package com.save.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.save.model.Victim;

public interface IVictimRepository extends JpaRepository<Victim, Long>{
	
	@Query(value="SELECT * FROM victim v ORDER BY v.firstname", nativeQuery=true)
	List<Victim> getVictimsListAlpha();
	
	@Query(value="SELECT v.firstname FROM victim v", nativeQuery=true)
	List<String> getFirstNameofVictims();
	
	//uniquement liste des victimes ayant latitude et longitude
	@Query(value="SELECT * FROM VICTIM v JOIN LOCATION l on v.FKLOCATION=l.id WHERE NOT (l.LATITUDE IS NULL "
			+ "OR l.LONGITUDE IS NULL)", nativeQuery=true)
	List<Victim> getVictimsWithLatLong();

}
