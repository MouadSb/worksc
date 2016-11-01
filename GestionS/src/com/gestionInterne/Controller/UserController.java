package com.gestionInterne.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.userdetails.User;

import com.gestionInterne.DAO.entity.Projet;
import com.gestionInterne.DAO.entity.Tach;
import com.gestionInterne.DAO.entity.tacheModel;
import com.gestionInterne.Service.Interface.InterfaceMetierModule;
import com.gestionInterne.Service.Interface.InterfaceMetierProjet;
import com.gestionInterne.Service.Interface.InterfaceMetierTach;
import com.gestionInterne.Service.Interface.UserInterfaceMetier;
import com.gestionInterne.Service.Interface.UserRolesInterfaceMetier;

@Controller
public class UserController {

	
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
	
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public String defaultPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This is default page!");
		model.setViewName("hello");
		
		return "redirect:/login";
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}

	@RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
	public String listRegistres(Model model) throws InterruptedException {
		  TimeUnit.MILLISECONDS.sleep(500);
	      User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      String name = user.getUsername();
	      List<Projet> projets;
	      
	      List<com.gestionInterne.DAO.entity.User> users = userMetier.getAllUser();
	      
	      List<tacheModel> tachModel = new ArrayList<tacheModel>();
	      com.gestionInterne.DAO.entity.User us = userMetier.getUser(name);
	      List<Tach> taches = userT.getAllTachByidU(us.getId()); //
	      projets = userP.getAllProjet();
	     for (Tach tach : taches) {
	    	 Projet p = userP.getProjet(tach.getIdProjet());
	    	 com.gestionInterne.DAO.entity.User usertmp = new com.gestionInterne.DAO.entity.User();
	    	 usertmp = userMetier.getUserById(p.getIdChef());
	    	 tacheModel t = new tacheModel();
	    	 t.setChefProjet(usertmp.getNom() + " "+ usertmp.getPrenom());
	    	 t.setDatedTache(tach.getDatedTache());
	    	 t.setDatefTache(tach.getDatefTache());
	    	 t.setNomClient(p.getNomClient());
	    	 t.setNomTache(tach.getNomTache());
	    	 t.setStatutTache(tach.getStatutTache());
	    	 t.setNomProjet(p.getNomProjet());
	    	 t.setIdTache(tach.getIdTache());
             t.setIdProjet(p.getIdProjet());
	    	if(us.getUserRoles().get(0).getRole().compareTo("ROLE_ADMIN")==0){
	    						 // ((Object) t).setNomUser(userMetier.getUser(projets.get(i).getIdUser()).getNom() + " "+ userMetier.getUser(projets.get(i).getIdUser()).getPrenom());	    						  
	    		t.setNomUtilisateur(userMetier.getUserById(p.getIdUser()).getNom()+ " "+ 
	    								  userMetier.getUserById(p.getIdUser()).getPrenom()
	    								  );	  
	    					  }
	    					  tachModel.add(t);	  
	     } 
	      model.addAttribute("currentUser",us.getNom() +" "+us.getPrenom() );
		  if(us.getUserRoles().get(0).getRole().compareTo("ROLE_ADMIN")==0){ 
			  model.addAttribute("listModule", userM.getAllModule());
	    	  return "adminCategorie";
	      }else{
	    	  model.addAttribute("listallprojet",userP.getAllProjet());
	    	  model.addAttribute("projetModel",new Projet());
		      model.addAttribute("Tach", new Tach());
		      model.addAttribute("listProjet", tachModel); // List project by id user ( session )
		      model.addAttribute("listptache", userP.getAllProjet()); // List name projects
			  model.addAttribute("chefList", users);
	    	  return "utilisateur";	  
	      }   	  
	}
	
	@RequestMapping(value = "/projet/add", method = RequestMethod.POST)
	public String addProjet(@ModelAttribute("projetModel") Projet p, Model model) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
		com.gestionInterne.DAO.entity.User us = userMetier.getUser(name);
		p.setIdUser(us.getId());
		p.setDateDP(new Date());
		p.setDateFP(new Date());
		p.setStatutP("");
		p.setDescriptionProjet(" ");
		userP.addProjet(p);
		return "redirect:/admin/projets";
	}
	
	@RequestMapping(value = "/tache/add", method = RequestMethod.POST)
	public String addTache(@ModelAttribute("Tach") Tach tache, Model model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
		tache.setStatutTache(" ");
		if(tache.getDatedTache()==null){
			tache.setDatedTache(new Date());
		}
		if(tache.getDatefTache()==null){
			tache.setDatefTache(new Date());
		}
		if(tache.getDescriptionTache()==null){
			tache.setDescriptionTache(" ");
		}
		if(tache.getNomTache()==null){
			tache.setNomTache(" ");
		}
		com.gestionInterne.DAO.entity.User us = userMetier.getUser(name);
		tache.setIdUser(us.getId());
		userT.addTach(tache);
		return "redirect:/index";

	}
	
	@ResponseBody
	@RequestMapping(value = "/projet/edit", method = RequestMethod.POST)
	public String projetEdit(
			@RequestParam String idProjet, @RequestParam String nomProjet,
			@RequestParam String chefProjet, @RequestParam String nomClient,Model model) {
		
		Projet projet = userP.getProjet(Integer.parseInt(idProjet));
		projet.setNomClient(nomClient);
		projet.setNomProjet(nomProjet);
		String string = chefProjet;
		String[] fullname = string.split(" ");
		String nom =fullname[0]; // nom
		String prenom = fullname[1]; // prenom
		com.gestionInterne.DAO.entity.User us = userMetier.getUserByfullName(nom, prenom);
		projet.setIdChef(us.getId());
		userP.updateProjet(projet);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/tache/edit", method = RequestMethod.POST)
	public String editTache(
			@RequestParam String idProjet, @RequestParam String idTache,
			@RequestParam String statu, @RequestParam String dateD,
			@RequestParam String dateF,@RequestParam String nomTache,
			Model model) throws ParseException {
		Tach t = userT.getTach(Integer.parseInt(idTache));
		List<Projet> listp = userP.getAllProjet();
		int idProjett=0;
		for (Projet projet : listp) {
			if(projet.getNomProjet().compareTo(idProjet)==0){
				idProjett=projet.getIdProjet();
			}
		}
		t.setIdProjet(idProjett);
		t.setNomTache(nomTache);
		t.setStatutTache(statu);
		t.setDatefTache(new SimpleDateFormat("yyyy-MM-dd").parse(dateF));
		t.setDatedTache(new SimpleDateFormat("yyyy-MM-dd").parse(dateD));
		userT.updateTach(t);
		
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/tache/remove/{id}", method = RequestMethod.DELETE)
	public String removeTache(@PathVariable("id") int id, Model model) {
		Tach t = userT.getTach(id);
		userT.deleteTach(t);
		return "redirect:/index";
	}

	
	@RequestMapping(value = "/projet/delete", method = RequestMethod.POST)
	public String removeProjet(
			Model model) {
		int id = 0;
		Projet projet = userP.getProjet(id);
		userP.deleteProjet(projet);
		return "redirect:/index";
	}
	
}
