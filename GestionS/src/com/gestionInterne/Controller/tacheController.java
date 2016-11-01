package com.gestionInterne.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gestionInterne.DAO.entity.Tach;
import com.gestionInterne.DAO.entity.tacheModel;
import com.gestionInterne.Service.Interface.InterfaceMetierModule;
import com.gestionInterne.Service.Interface.InterfaceMetierProjet;
import com.gestionInterne.Service.Interface.InterfaceMetierTach;
import com.gestionInterne.Service.Interface.UserInterfaceMetier;
import com.gestionInterne.Service.Interface.UserRolesInterfaceMetier;
import com.google.gson.Gson;


@Controller
public class tacheController {

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
	@RequestMapping(value="/tacheA/getAll", method = RequestMethod.POST)
	public String getTachebyIdP(@RequestParam String idProjet){
		List<Tach> taches = userT.getAllTachByidP(Integer.valueOf(idProjet));
		//List<tacheModel> tachModel = new ArrayList<tacheModel>();
		int cpt=0;
	    String chaineD="";
		for (Tach tm : taches) {
			
			com.gestionInterne.DAO.entity.User us = userMetier.getUserById(tm.getIdUser());
			//tacheModel t = new tacheModel();
			
			chaineD=chaineD+"[\""+tm.getNomTache()+"\",\""+tm.getDatedTache()+"\",\""+tm.getDatefTache()+
					"\",\""+tm.getDescriptionTache()+"\",\""
					+tm.getStatutTache()+"\",\""+us.getNom()+" "+us.getPrenom()+"\",\""+tm.getIdTache()+"\"]";
			/*t.setNomTache(tm.getNomTache());
			t.setDatedTache(tm.getDatedTache());
			t.setDatefTache(tm.getDatefTache());
			t.setDescriptionTache(tm.getDescriptionTache());
			t.setStatutTache(tm.getStatutTache());
			t.setNomUtilisateur(us.getNom()+" "+us.getPrenom());
			t.setIdTache(tm.getIdTache());
			tachModel.add(t);*/
			cpt++;
			if(cpt<taches.size()){
				chaineD= chaineD+",";
			}
			
		}
		System.out.println(" IdProjet :"+ idProjet);
		//System.out.println("----------------"+cpt+" "+ taches.size());
		//String json = new Gson().toJson("[ "+chaineD+" ]");
		return "[ "+chaineD+" ]";
	}
}
