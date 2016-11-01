package com.gestionInterne.Service.Interface;

import java.util.List;

import com.gestionInterne.DAO.entity.Projet;

public interface InterfaceMetierProjet {

	public Projet addProjet(Projet p);

	public void deleteProjet(Projet p);

	public Projet updateProjet(Projet p);

	public Projet getProjet(String idProjet);

	public List<Projet> getAllProjet();

}
