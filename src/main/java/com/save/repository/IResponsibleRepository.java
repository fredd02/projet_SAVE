package com.save.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.save.model.Responsible;

public interface IResponsibleRepository extends JpaRepository<Responsible, Long>{
	
	//liste des responsables d'une victime
	@Query(value="SELECT * FROM RESPONSIBLE r JOIN VICTIME_RESPONSIBLE vr on r.id = vr.FKRESPONSIBLE where vr.FKVICTIM = ?1", nativeQuery=true)
	List<Responsible> getResponsiblesFromVictim(Long id);

}
