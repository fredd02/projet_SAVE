package com.save.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.save.model.Location;
import com.save.model.Victim;
import com.save.repository.ILocationRepository;
import com.save.repository.IVictimRepository;

@Controller
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	IVictimRepository victimDAO;
	
	@Autowired
	ILocationRepository locationDAO;
	
	//logger
		private final Logger log = LoggerFactory.getLogger(this.getClass());
	
		
		//methode GET pour ajouter une localisation
	@RequestMapping(value="/{id}/add", method=RequestMethod.GET)
	public String addLocation(@PathVariable Long id, @ModelAttribute Location location, Model model) {
		
		log.info("methode get pour ajouter une localisation");
		
		Victim victim = victimDAO.findOne(id);
		
		model.addAttribute("victim", victim);
		model.addAttribute("location", location);
		
		return "location/addLocation";
	}
	
	
	//methode POST pour ajouter une localisation
	@RequestMapping(value="/{id}/add", method = RequestMethod.POST)
	public String addLocationPost(@PathVariable Long id, @Valid Location location, BindingResult errors, Model model,
					RedirectAttributes rModel) {
		log.info("methode POST pour encoder une localisation");
		
		//gestion de la validation
		if (errors.hasErrors()) {
			return "location/addLocation";
		} else {
			
			Location location_saved = locationDAO.save(location);
			log.info("code postal: " + location_saved.getPostCode());
			
			rModel.addFlashAttribute(location_saved);
			
			return "redirect:/location/" + location_saved.getId();
			
		}
	}
	
	//methode GET pour afficher les détails d'une localisation
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String infosLocation() {
		
		return "location/location";
	}

	

}
