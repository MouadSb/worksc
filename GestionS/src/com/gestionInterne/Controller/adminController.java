package com.gestionInterne.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gestionInterne.DAO.entity.Projet;
import com.gestionInterne.DAO.entity.Tach;
import com.gestionInterne.DAO.entity.User;
import com.gestionInterne.Service.Interface.InterfaceMetierModule;
import com.gestionInterne.Service.Interface.InterfaceMetierProjet;
import com.gestionInterne.Service.Interface.InterfaceMetierTach;
import com.gestionInterne.Service.Interface.UserInterfaceMetier;
import com.gestionInterne.Service.Interface.UserRolesInterfaceMetier;


@Controller
@RequestMapping("/admin")
public class adminController {
	
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
	
	
	
	
	@RequestMapping("/redirect")
	public String redirect(@RequestParam(value="selectCat", required=false) String selectCat,Model model){
		if(selectCat.compareTo("Projets")==0){
			
		      return "redirect:projets";
		}else if(selectCat.compareTo("Employés")==0){
			  model.addAttribute("listUser", userMetier.getAllUser());
			  return "adminEmployes";
		}else if(selectCat.compareTo("Clients")==0){
			  return "adminClients";
		}
		
		
		System.out.println(" Cat : "+ selectCat);
		return "hello";
	}
	
	@RequestMapping("/projets")
	public String pageProjets(Model model) throws InterruptedException{
		  TimeUnit.MILLISECONDS.sleep(500);

		List<com.gestionInterne.DAO.entity.User> users = userMetier.getAllUser();
		List<Projet> listp = userP.getAllProjet();
		for (Projet projet : listp) {
			User u = new User();
			u= userMetier.getUserById(projet.getIdChef());
			projet.setNomChef(u.getNom()+" "+u.getPrenom());
		}
		for (com.gestionInterne.DAO.entity.User user : users) {
			user.setNomComplet(user.getNom()+" "+user.getPrenom());
		}
		  model.addAttribute("chefList", users);
	      model.addAttribute("listsprojets", listp); // List name projects
	      model.addAttribute("projetModel",new Projet());
	      return "adminProjets";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getProjet", method = RequestMethod.POST, produces="application/json")
	public String pageProjets(@RequestParam String id){
		Projet p = userP.getProjet(Integer.valueOf(id));
		User u = userMetier.getUserById(p.getIdChef());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return "{\"nomProjet\":\""+p.getNomProjet()+"\", \"proprietaireP\": \""+u.getNom()+" "+u.getPrenom()+"\", \"dateD\": \""+ formatter.format(p.getDateDP())
				+"\", \"statutP\": \""+p.getStatutP()+
				"\", \"description\": \""+p.getDescriptionProjet()+"\", \"dateF\": \""+formatter.format(p.getDateFP())+"\"}";
	}
	
	
	



}
