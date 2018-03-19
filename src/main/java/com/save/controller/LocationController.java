package com.save.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.save.model.Location;
import com.save.model.Victim;
import com.save.repository.ILocationRepository;
import com.save.repository.IVictimRepository;
import com.save.web.NoAccessException;
import com.save.web.NotFoundException;

@Controller
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	IVictimRepository victimDAO;
	
	@Autowired
	ILocationRepository locationDAO;
	
	//logger
		private final Logger log = LoggerFactory.getLogger(this.getClass());
	
		/**
		 * methode GET pour ajouter une localisation à une victime
		 * @param id
		 * 		id de la victime
		 * @param latitude
		 * 		latitude de la localisation
		 * @param longitude
		 * 		longitude de la localisation
		 * @param location
		 * 		objet location ajouté au model
		 * @param model
		 * 		modele passé à la page jsp
		 * @return
		 * 		chemin vers la page jsp pour ajouter une localisation
		 */
		
	@RequestMapping(value="/{id}/add", method=RequestMethod.GET)
	public String addLocation(@PathVariable Long id, @RequestParam(value="latitude", required=false) Double latitude, 
			@RequestParam(value="longitude", required=false) Double longitude,
			@ModelAttribute Location location, Model model) {
		
		log.info("methode get pour ajouter une localisation");
		
		//verifie si la victime existe
		if(!victimDAO.exists(id)) {
			String message = String.format("la victime %d n'existe pas", id);
			log.info(message);
			throw new NotFoundException("la victime n'existe pas", id);
		}
			
		
		//chargement de la localisation relative à la victime
		Long location_id = locationDAO.GetLocationIdFromVictimId(id);
		if(location_id!=null) {
			location = locationDAO.findOne(location_id);
		}
		
		if (latitude != null) {
			log.info("latitude: " + latitude);
			location.setLatitude(latitude);
		}
		if (longitude != null) {
			log.info("longitude: " + longitude);
			location.setLongitude(longitude);
		}
		
		
		
		Victim victim = victimDAO.findOne(id);
		
		model.addAttribute("victim", victim);
		model.addAttribute("location", location);
		
		return "location/addLocation";
	}
	
	/**
	 * methode POST pour ajouter une localisation
	 * @param id
	 * 		id de la victime
	 * @param toMaps
	 * 		si="ok", indique qu'on doit être redirigé vers la carte pour insérer latitude et longitude
	 * @param location
	 * 		
	 * @param errors
	 * 		erreurs éventuelles de validation du formulaire
	 * 		
	 * @param model
	 * @param rModel
	 * 		pour que les attributs du modele survivent à la redirection
	 * @return
	 * 		redirige vers la page jsp pour voir les infos de la localisation
	 */
	
	@RequestMapping(value="/{id}/add", method = RequestMethod.POST)
	public String addLocationPost(@PathVariable Long id, @RequestParam(value="toMaps", required=false)String toMaps,@Valid Location location, BindingResult errors, Model model,
					RedirectAttributes rModel) {
		log.info("methode POST pour encoder une localisation");
		
		//gestion de la validation
		if (errors.hasErrors()) {
			return "location/addLocation";
		} else {
			
			Location location_saved = locationDAO.save(location);
			log.info("code postal: " + location_saved.getPostCode());
			Victim victim = victimDAO.findOne(id);
			victim.setLocation(location_saved);
			victimDAO.save(victim);
			if(toMaps.equals("ok")) {
				model.addAttribute("addOrUpdate","add");
				return "maps";
			}
			
			rModel.addFlashAttribute(location_saved);
			
			return "redirect:/location/" + location_saved.getId();
			
		}
	}
	
	/**
	 * methode GET pour afficher les details d'une localisation
	 * @param id
	 * 		id de la localisation
	 * @param model
	 * @return
	 * 		retourne la page jsp de details d'une localisation
	 */
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String infosLocation(@PathVariable Long id, Model model) {
		
		if(!model.containsAttribute("location")) {
			Location location = locationDAO.findOne(id);
			model.addAttribute("location", location);
		}
		
		return "location/location";
	}
	
	/**
	 * methode GET pour updater une localisation
	 * @param id
	 * 		id de la localisation
	 * @param latitude
	 * 		latitude de la localisation (si on vient de la carte)
	 * @param longitude
	 * 		longitude de la localisation (si on vient de la carte)
	 * @param model
	 * @return
	 * 		retourne la page jsp pour modifier la localisation
	 */
	
	@RequestMapping(value="{id}/update", method=RequestMethod.GET)
	public String localisationUpdateGet(@PathVariable Long id, @RequestParam(value="latitude", required=false) Double latitude,
			@RequestParam(value="longitude", required=false)Double longitude, Model model) {
		log.info("methode GET pour updater une localisation");
		
		//verifie si la localisation existe
		if(!locationDAO.exists(id))
			throw new NotFoundException("localisation non trouvée pour update", id);
		
		//recherche id de la victime
		Long victim_id = locationDAO.GetVictimIdFromLocationId(id);
		
		Location location = locationDAO.getOne(id);
		model.addAttribute("location", location);
		Victim victim = victimDAO.findOne(victim_id);
		model.addAttribute("victim", victim);
		
		if (latitude != null) {
			log.info("latitude: " + latitude);
			location.setLatitude(latitude);
		}
		if (longitude != null) {
			log.info("longitude: " + longitude);
			location.setLongitude(longitude);
		}
		
		return "location/updateLocation";
	}
	
	//methode POST pour updater une localisation
	@RequestMapping(value="{id}/update", method=RequestMethod.POST)
	public String locationUpdatePost(@PathVariable Long id, @Valid Location location, 
			@RequestParam(value="toMaps", required=false)String toMaps,BindingResult errors,
			Model model, RedirectAttributes rModel) {
		log.info("methode POST pour updater une localisation");
		
		//gestion de la validation
		if(errors.hasErrors()) {
			return "location/updateLocation";
		}else {
			Location location_saved = locationDAO.save(location);
			
			if(toMaps.equals("ok")) {
				model.addAttribute("addOrUpdate","update");
				return "maps";
			}
			rModel.addFlashAttribute(location_saved);
			return "location/location";
		}
			
	}
	
	/**
	 * methode POST pour supprimer une localisation
	 * @param id
	 * 		id de la localisation à supprimer
	 * @return
	 * 		redirige sur la page jsp de liste des victimes
	 */
	
	@RequestMapping(value="{id}/delete", method=RequestMethod.POST)
	public String locationDeletePost(@PathVariable Long id) {
		log.info("methode POST pour effacer une victime");
		//verifie si la localisation existe
		if(!locationDAO.exists(id))
			throw new NotFoundException("localisation non trouv�e ", id);
		try {
			//suppression de la localisation sur les victimes concern�es
			List<Victim> listVictims = victimDAO.getVictimsFromLocation(id);
			for(Victim victim : listVictims){
				victim.setLocation(null);
				
			}
			locationDAO.delete(id);
		}catch (DataIntegrityViolationException e) {
			log.error("SQL", e);
			throw new NoAccessException("suppression impossible: cette localisation poss�de des d�pendances");
		}
		log.info("suppression de la localisation " + id );
		return "redirect:/victim/list";
	}

	

}
