package com.save.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.save.model.Victim;

public interface IVictimRepository extends CrudRepository<Victim, Long>{
	
	@Query(value="SELECT * FROM victim v ORDER BY v.firstname", nativeQuery=true)
	List<Victim> getVictimsListAlpha();
	
	@Query(value="SELECT v.firstname FROM victim v", nativeQuery=true)
	List<String> getFirstNameofVictims();

}
