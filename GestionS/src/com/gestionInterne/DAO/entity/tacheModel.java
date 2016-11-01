package com.gestionInterne.DAO.entity;

import java.sql.Timestamp;
import java.util.Date;

public class tacheModel {
	
	private Date datedTache;

	private Date datefTache;

	private String descriptionTache;
	
	private String nomTache;

	private String statutTache;
	
	private String nomClient;
	
	private String chefProjet;
	
	private String nomUtilisateur;
	
	private String nomProjet;
	
	private int idTache;
	
	private int idProjet;
	
	public Date getDatedTache() {
		return datedTache;
	}

	public void setDatedTache(Date datedTache) {
		this.datedTache = datedTache;
	}

	public Date getDatefTache() {
		return datefTache;
	}

	public void setDatefTache(Date datefTache) {
		this.datefTache = datefTache;
	}

	public String getDescriptionTache() {
		return descriptionTache;
	}

	public void setDescriptionTache(String descriptionTache) {
		this.descriptionTache = descriptionTache;
	}

	public String getNomTache() {
		return nomTache;
	}

	public void setNomTache(String nomTache) {
		this.nomTache = nomTache;
	}

	public String getStatutTache() {
		return statutTache;
	}

	public void setStatutTache(String statutTache) {
		this.statutTache = statutTache;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getChefProjet() {
		return chefProjet;
	}

	public void setChefProjet(String chefProjet) {
		this.chefProjet = chefProjet;
	}

	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public int getIdTache() {
		return idTache;
	}

	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}

	public int getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	@Override
	public String toString() {
		return "tacheModel [datedTache=" + datedTache + ", datefTache="
				+ datefTache + ", descriptionTache=" + descriptionTache
				+ ", nomTache=" + nomTache + ", statutTache=" + statutTache
				+ ", nomClient=" + nomClient + ", chefProjet=" + chefProjet
				+ ", nomUtilisateur=" + nomUtilisateur + ", nomProjet="
				+ nomProjet + ", idTache=" + idTache + ", idProjet=" + idProjet
				+ "]";
	}


	
	
	
}
