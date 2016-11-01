package com.gestionInterne.DAO.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the projet database table.
 * 
 */
@Entity
@Table ( name = "projet", catalog = "gestionactivities")
public class Projet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idProjet;

	private int descriptionProjet;

	private int idChef;

	private int idUser;

	private String nomProjet;

	public Projet() {
	}

	public String getIdProjet() {
		return this.idProjet;
	}

	public void setIdProjet(String idProjet) {
		this.idProjet = idProjet;
	}

	public int getDescriptionProjet() {
		return this.descriptionProjet;
	}

	public void setDescriptionProjet(int descriptionProjet) {
		this.descriptionProjet = descriptionProjet;
	}

	public int getIdChef() {
		return this.idChef;
	}

	public void setIdChef(int idChef) {
		this.idChef = idChef;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNomProjet() {
		return this.nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

}