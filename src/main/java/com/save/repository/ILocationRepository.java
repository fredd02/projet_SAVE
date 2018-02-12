package com.save.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.save.model.Location;

public interface ILocationRepository extends JpaRepository<Location, Long>{
	
	//id de la victime à partir de l'id de la localisation
	@Query(value="SELECT v.id FROM LOCATION l JOIN VICTIM v on v.FKLOCATION=l.id WHERE l.id=?1", nativeQuery=true)
	Long GetVictimIdFromLocationId(Long id);
	
	//id de la localisation à partir de l'id de la victime
	@Query(value="SELECT l.id FROM LOCATION l JOIN VICTIM v on v.FKLOCATION=l.id WHERE v.id=?1", nativeQuery=true)
	Long GetLocationIdFromVictimId(Long id);
	

}
