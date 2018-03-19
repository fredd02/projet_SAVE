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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.save.model.Victim;
import com.save.repository.IVictimRepository;
import com.save.web.NoAccessException;
import com.save.web.NotFoundException;



@Controller
@RequestMapping("/victim")
public class VictimController {

	//logger
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IVictimRepository victimDAO;
	
	
	/**
	 * methode GET pour afficher la liste des victimes
	 * @param model
	 * 		model transmis à la page jsp
	 * @return
	 * 		retourne le chemin de la page jsp qui affiche la liste
	 */
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String victimList(Model model) {
		log.info("method get pour afficher la liste des victimes");
		
		List<Victim> victimsList = victimDAO.getVictimsListAlpha();
		
		log.debug("nb de victimes: " + victimsList.size());
		model.addAttribute("victimsList", victimsList);
		
		
		return "victim/victimsList";
	}
	
	/**
	 * methode GET pour ajouter une victime
	 * @param victim
	 * 		instance de Victim
	 * @param model
	 * 		model contenant victim à passer à la vue
	 * @return
	 * 		vue jsp pour encoder une victime
	 */
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String victimAddGet(@ModelAttribute Victim victim, Model model) {
		log.info("methode GET pour ajouter une victime");
		
		model.addAttribute("victim", victim);
		return "victim/addVictim";
	}
	
	
	//methode POST pour encoder une victime
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String victimAddPost(@Valid Victim victim, BindingResult errors, Model model, RedirectAttributes rModel) {
		
		log.info("methode POST pour encoder une victime");
		
		//gestion de la validation
				if(errors.hasErrors()) {
					return "victim/addVictim";
				}else {
					
					Victim victim_saved = victimDAO.save(victim);
					log.debug("victime: " + victim_saved.getFirstname());
					
					
					rModel.addFlashAttribute(victim_saved);
					
					return "redirect:/victim/" + victim_saved.getId();
				}
		
	}
	/**
	 * methode GET pour afficher les infos d'une victime
	 * @param id
	 * 		id de la victime
	 * @param model
	 * 		modèle qui va contenir les infos de la victime
	 * @return
	 * 		page jsp avec infos de la victime
	 */
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String victim(@PathVariable Long id, Model model) {
		
		log.info("methode GET pour afficher les details d'une victime");
		
		//verifie si la victime existe
		if(!victimDAO.exists(id)) {
			throw new NotFoundException("la victime n'existe pas", id);
		}
		
		//verifie si on ne vient pas d'une redirection
		if(! model.containsAttribute("victim")) {
			log.info("recherche de la victime dans la BD");
			Victim victim = victimDAO.findOne(id);
			
			model.addAttribute("victim", victim);
		}
		
		
		
		
		return "victim/victim";
	}
	
	
	//methode POST pour supprimer une victime
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.POST)
	public String deleteVictim(@PathVariable Long id) {
		log.info("methode POST pour supprimer une victime");
		//verifie si la victime existe
		if(!victimDAO.exists(id)) 
			throw new NotFoundException("victime non trouvée pour suppression ",id);
		try {
			victimDAO.delete(id);
		} catch (DataIntegrityViolationException e) {
			log.error("SQL", e);
			throw new NoAccessException(" Suppression impossible: cette victime possède des dépendances");
			
		}
		log.info("suppression de la victime: " + id);
		return "redirect:/victim/list";
		
	}
	
	//methode GET pour updater une victime
	@RequestMapping(value="/{id}/update", method=RequestMethod.GET)
	public String updateVictimGet(@PathVariable Long id, Model model) {
		log.info("methode GET pour updater une victime");
		//verifie si la victime existe
		if(!victimDAO.exists(id))
			throw new NotFoundException("victime non trouvée pour update ", id);
		
		Victim victim = victimDAO.getOne(id);
		model.addAttribute("victim", victim);
		
		return "victim/updateVictim";

	}
	
	//methode POST pour updater une victime
	@RequestMapping(value="/{id}/update", method=RequestMethod.POST)
		public String updateVictimPost(@PathVariable Long id,@Valid Victim victim,BindingResult errors, 
				Model model, RedirectAttributes rModel) {
			
			log.info("methode POST pour updater une victime");
			
			//gestion de la validation
			if(errors.hasErrors()) {
				log.info("erreurs de validation pour l'update: " + errors.toString());
				return "victim/"+id+"/update";
			}else {
				Victim victim_updat = victimDAO.save(victim);
				rModel.addFlashAttribute(victim_updat);
				
				return "redirect:/victim/" + victim_updat.getId();
				
			}
			
		}
	


}
