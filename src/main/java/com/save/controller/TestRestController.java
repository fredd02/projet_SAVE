package com.save.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.save.model.Star;
import com.save.model.Victim;
import com.save.repository.IVictimRepository;

@RestController
public class TestRestController {
	
	//logger
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IVictimRepository victimDAO;
	
	

	@RequestMapping("/star")
	public Victim victim(@RequestParam(value="id", defaultValue="1")Long id) {
		
		log.info("method REST pour afficher une victime en JSON");
		Victim victim = victimDAO.findOne(id);
		
		return victim;
		
	}
	
	/**
	 * methode qui renvoie la liste des victimes qui ont paramètres latitude et longitude (pour affichage google maps)
	 * @return
	 * 		fichier JSON avec la liste des victimes
	 */
	
	@CrossOrigin(origins= "http://localhost:8383")
	@RequestMapping("/stars")
	public List<Star> listStars(){
		//liste des victimes ayant param Latitude et longitude
		List<Victim> list = victimDAO.getVictimsWithLatLong();
		List<Star> StarList = new ArrayList<>();
		Star star_temp;
		
		for(Victim v: list	) {
			//log.info("nom de la victime: " + v.getFirstname());
			star_temp = new Star(v);
			//log.info("nom de la star: " + star_temp.getFirstname());
			log.info(star_temp.toString());
			StarList.add(new Star(v));
		}
		return StarList;
	}

}
