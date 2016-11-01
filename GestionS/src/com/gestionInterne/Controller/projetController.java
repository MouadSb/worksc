package com.gestionInterne.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gestionInterne.DAO.entity.Projet;
import com.gestionInterne.Service.Interface.InterfaceMetierModule;
import com.gestionInterne.Service.Interface.InterfaceMetierProjet;
import com.gestionInterne.Service.Interface.InterfaceMetierTach;
import com.gestionInterne.Service.Interface.UserInterfaceMetier;
import com.gestionInterne.Service.Interface.UserRolesInterfaceMetier;

@Controller
public class projetController {

	@Autowired
	private InterfaceMetierTach userT;
	
	@Autowired
	private InterfaceMetierProjet userP;

	@Autowired
	private UserInterfaceMetier userMetier;
	
	@Autowired
	private UserRolesInterfaceMetier userRoleMetier;

	@Autowired
	private InterfaceMetierModule userM;
	
	
	@ResponseBody
	@RequestMapping(value = "/projetA/edit", method = RequestMethod.POST,produces="application/json")
	public String editorProjet(@RequestParam String idProjet, @RequestParam String nomProjet,
			@RequestParam String proprietaire, @RequestParam String dateD,
			@RequestParam String dateF, @RequestParam String statu,
			@RequestParam String description) throws ParseException{
		try{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Projet p = userP.getProjet(Integer.valueOf(idProjet));
			p.setNomProjet(nomProjet);
			p.setDateDP(formatter.parse(dateD));
			p.setDateFP(formatter.parse(dateF));
			p.setStatutP(statu);
			p.setDescriptionProjet(description);
			String string = proprietaire;
			String[] fullname = string.split(" ");
			String nom =fullname[0]; // nom
			String prenom = fullname[1]; // prenom
			System.out.println(nom + " --- "+ prenom);
			com.gestionInterne.DAO.entity.User us = userMetier.getUserByfullName(nom, prenom);
			System.out.println("id - "+ us.getId());
			p.setIdChef(us.getId());	
			userP.updateProjet(p);
			return "{\"success\":\"1\"}";
		}catch(ParseException e){
			return "{\"success\":\"0\"}";
		} 
		
		
	}
	
	@RequestMapping(value = "/projetA/remove/{id}", method = RequestMethod.DELETE)
	public String removeTache(@PathVariable("id") int id, Model model) {
		Projet projet = userP.getProjet(Integer.valueOf(id));
		userP.deleteProjet(projet);
		return "redirect:/admin/projets";
	}
}
