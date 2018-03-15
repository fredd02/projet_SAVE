package com.save.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.save.model.Star;
import com.save.model.Victim;
import com.save.repository.IVictimRepository;

@Controller
@RequestMapping("/starlight")
public class StarlightController {
	
	//logger
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IVictimRepository victimDAO;
	
	
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String starlight(Model model) {
		
		log.info("methode GET pour afficher la carte étoilée");
		//Liste avec prenom et age des victimes
		List<Victim> list = victimDAO.getVictimsWithLatLong();
		log.info(list.get(0).getLastname());
		List<Star> starList = new ArrayList<>();
		Star star_temp;
		
		for(Victim v: list	) {
			star_temp = new Star(v);
			starList.add(new Star(v));
		}
		//sousliste avec 6 éléments pour debug. A REMPLACER!!
		/*List<Star> starDebug = starList.subList(0, 5);*/
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			String starsToJson = mapper.writeValueAsString(starList);
			log.info(starsToJson);
			
			model.addAttribute("stars",starsToJson);
		} catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		
		return "starlight";
	}
	

	

}
