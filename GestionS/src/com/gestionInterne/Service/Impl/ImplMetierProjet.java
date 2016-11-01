package com.gestionInterne.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gestionInterne.DAO.entity.Projet;
import com.gestionInterne.DAO.intDAO.InterfaceProjet;
import com.gestionInterne.Service.Interface.InterfaceMetierProjet;

@Component
public class ImplMetierProjet implements InterfaceMetierProjet {

	@Autowired
	private InterfaceProjet ip;
	
	public void setIp(InterfaceProjet ip) {
		this.ip = ip;
	}

	@Override
	public Projet addProjet(Projet p) {
		return ip.addProjet(p);
	}

	@Override
	public void deleteProjet(Projet p) {
		ip.deleteProjet(p);
	}

	@Override
	public Projet updateProjet(Projet p) {
		return ip.updateProjet(p);
	}

	@Override
	public Projet getProjet(int idProjet) {
		return ip.getProjet(idProjet);
	}

	@Override
	public List<Projet> getAllProjet() {
		return ip.getAllProjet();
	}

	@Override
	public List<Projet> getAllProjetbyName(int idname) {
		return ip.getAllProjetbyName(idname);
	}

	@Override
	public List<Projet> getAllProjetbyChef(int idname) {
		return ip.getAllProjetbyChef(idname);
	}

}
