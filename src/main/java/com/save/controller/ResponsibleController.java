package com.save.controller;

import java.util.Iterator;
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

import com.save.model.Responsible;
import com.save.model.Victim;
import com.save.repository.IResponsibleRepository;
import com.save.repository.IVictimRepository;
import com.save.web.NoAccessException;
import com.save.web.NotFoundException;

@Controller
@RequestMapping("responsible")
public class ResponsibleController {
	
	@Autowired
	IVictimRepository victimDAO;
	
	@Autowired
	IResponsibleRepository responsibleDAO;
	
	//logger
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * methode GET pour ajouter une personne de contact à une victime
	 * @param id
	 * 		id de la victime
	 * @param responsible
	 * 		objet responsible à ajouter au modèle
	 * @param model
	 * 		model envoyé à la vue jsp
	 * @return
	 * 		chemin de la vue jsp
	 */
	
	@RequestMapping(value="/{id}/add", method=RequestMethod.GET)
	public String addResponsibleGet(@PathVariable Long id, @ModelAttribute Responsible responsible, Model model) {
		
		log.info("methode get pour ajouter un responsable");
		
		Victim victim = victimDAO.getOne(id);
		model.addAttribute("victim", victim);
		
		return "responsible/addResponsible";
		
	}
	
	/**
	 * Methode POST pour ajouter une personne de contact à une victime
	 * @param id
	 * 		id de la victime
	 * @param responsible
	 * 		responsable récupéré du formulaire de la page jsp
	 * @param errors
	 * 		erreurs éventuelles à l'encodage
	 * @param model
	 * @param rModel
	 * 		pour que les données du responsable survivent à la redirection
	 * @return
	 * 		redirige vers la page d'information sur le responsable
	 */
	
	@RequestMapping(value="/{id}/add", method=RequestMethod.POST)
	public String addResponsiblePost(@PathVariable Long id,@Valid Responsible responsible,BindingResult errors, Model model,
					RedirectAttributes rModel) {
		
		log.info("methode POST pour encoder un responsable");
		
		//gestion de la validation
				if (errors.hasErrors()) {
					return "responsible/addResponsible";
				} else {
					
					Responsible responsible_saved = responsibleDAO.save(responsible);
					
					Victim victim = victimDAO.findOne(id);
					victim.addResponsible(responsible_saved);
					victimDAO.save(victim);
					
					rModel.addFlashAttribute(responsible_saved);
					
					return "redirect:/responsible/" + responsible_saved.getId();
				}
		
	}
	
	//methode GET pour afficher les details d'un responsable
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String infosResponsable(@PathVariable Long id, Model model) {
		if(!model.containsAttribute("responsible")) {
			Responsible responsible = responsibleDAO.findOne(id);
			model.addAttribute("responsible", responsible);
			
			
		}
		return "responsible/responsible";
	}
	
	//methode GET pour afficher les responsables d'une victime
	@RequestMapping(value="/list/{id}", method=RequestMethod.GET)
	public String ResponsablesFromVictim(@PathVariable Long id, Model model) {
		log.info("methode GET pour afficher les responsables d'une victime");
		//recupere la liste des responsables d'une victime
		List<Responsible> listResponsibles = responsibleDAO.getResponsiblesFromVictim(id);
		Victim victim = victimDAO.findOne(id);
		model.addAttribute("listResponsibles", listResponsibles);
		model.addAttribute("victim", victim);
		
		
		return "responsible/responsiblesVictim";
	}
	
	//methode GET pour updater un responsable
	@RequestMapping(value="{id}/update", method=RequestMethod.GET)
	public String responsibleUpdateGet(@PathVariable Long id, Model model) {
		log.info("methode GET pour updater un responsable");
		
		//verifie si le responsable existe
		if(!responsibleDAO.exists(id))
			throw new NotFoundException("responsable non trouv� pour update" , id);
		
		Responsible responsible = responsibleDAO.findOne(id);
		model.addAttribute("responsible", responsible);
		
		return "responsible/updateResponsible";
	}
	
	//methode POST pour updater un responsable
	@RequestMapping(value="{id}/update", method=RequestMethod.POST)
	public String responsibleUpdatePost(@PathVariable Long id, @Valid Responsible responsible, BindingResult errors, 
			Model model, RedirectAttributes rModel) {
		
			log.info("methode POST pour updater un responsable");
			
			//gestion de la validation
			if(errors.hasErrors()) {
				return "reponsible/"+id+"/update";
			}else {
				Responsible responsible_updat = responsibleDAO.save(responsible);
				rModel.addFlashAttribute(responsible_updat);
				
				return "redirect:/responsible/"+responsible_updat.getId();
			}
		
	}
	
	//methode POST pour supprimer un responsable
	@RequestMapping(value="/{id}/delete", method=RequestMethod.POST)
	public String responsibleDeletePost(@PathVariable Long id) {
		
		log.info("methode POST pour supprimer un responsable");
		//verifie si le responsable existe
		if(!responsibleDAO.exists(id))
			throw new NotFoundException("responsable non trouv� pour suppression", id);
		
		//suppression du lien avec la victime
		List<Victim> listVictimsFromResponsible = victimDAO.getVictimFromResponsible(id);
		Iterator i = listVictimsFromResponsible.iterator();
		while(i.hasNext()) {
			Victim v = (Victim)i.next();
			v.setResponsibles(null);
		}
			
		try {
			responsibleDAO.delete(id);
		} catch (DataIntegrityViolationException e) {
			log.error("SQL", e);
			throw new NoAccessException("Suppression impossible: ce responsable poss�de des d�pendances");
		}
		log.info("suppression du responsable: " + id);
		return "redirect:/victim/list";
	}

}
