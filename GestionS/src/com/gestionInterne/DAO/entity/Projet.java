package com.gestionInterne.DAO.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * The persistent class for the projet database table.
 * 
 */
@Entity
@Table ( name = "projet", catalog = "gestionactivities")
public class Projet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProjet;

	private int idChef;

	private int idUser;

	private String nomProjet;
	
	private String nomClient;
	
	private String statutP;
	
	@Transient
	private String nomChef;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDP;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateFP;
	
	private String descriptionProjet;
	
	

	public Projet() {
	}

	public int getIdProjet() {
		return this.idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
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

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getStatutP() {
		return statutP;
	}

	public void setStatutP(String statutP) {
		this.statutP = statutP;
	}

	public Date getDateDP() {
		return dateDP;
	}

	public void setDateDP(Date dateDP) {
		this.dateDP = dateDP;
	}

	public Date getDateFP() {
		return dateFP;
	}

	public void setDateFP(Date dateFP) {
		this.dateFP = dateFP;
	}

	public String getNomChef() {
		return nomChef;
	}

	public void setNomChef(String nomChef) {
		this.nomChef = nomChef;
	}

	public String getDescriptionProjet() {
		return descriptionProjet;
	}

	public void setDescriptionProjet(String descriptionProjet) {
		this.descriptionProjet = descriptionProjet;
	}
	
	

}