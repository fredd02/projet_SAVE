package com.save.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.save.model.Location;

@Controller
@RequestMapping("/location")
public class LocationController {
	
	//logger
		private final Logger log = LoggerFactory.getLogger(this.getClass());
	
		
		//methode GET pour ajouter une localisation
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addLocation(@ModelAttribute Location location, Model model) {
		
		log.info("methode get pour ajouter une localisation");
		
		model.addAttribute("location", location);
		
		return "location/addLocation";
	}

	

}
