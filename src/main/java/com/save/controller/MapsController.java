package com.save.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/maps")
public class MapsController {
	
	//logger
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value="", method=RequestMethod.GET)
	public String getMaps() {
		log.info("methode GET pour afficher la map");
		
		return "maps";
	}

}
