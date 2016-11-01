package com.gestionInterne.DAO.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the taches database table.
 * 
 */
@Entity
@Table(name="taches", catalog = "gestionactivities")
public class Tach implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTache;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datedTache;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datefTache;

	private int idProjet;

	private String nomTache;

	private String statutTache;
	
	private int idUser;
	
	private String descriptionTache;
	

	public Tach() {
	}

	public int getIdTache() {
		return this.idTache;
	}

	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}

	public Date getDatedTache() {
		return this.datedTache;
	}

	public void setDatedTache(Date datedTache) {
		this.datedTache = datedTache;
	}

	public Date getDatefTache() {
		return this.datefTache;
	}

	public void setDatefTache(Date datefTache) {
		this.datefTache = datefTache;
	}

	public int getIdProjet() {
		return this.idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}

	public String getNomTache() {
		return this.nomTache;
	}

	public void setNomTache(String nomTache) {
		this.nomTache = nomTache;
	}

	public String getStatutTache() {
		return this.statutTache;
	}

	public void setStatutTache(String statutTache) {
		this.statutTache = statutTache;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getDescriptionTache() {
		return descriptionTache;
	}

	public void setDescriptionTache(String descriptionTache) {
		this.descriptionTache = descriptionTache;
	}

	
}