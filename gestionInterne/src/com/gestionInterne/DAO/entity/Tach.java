package com.gestionInterne.DAO.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the taches database table.
 * 
 */
@Entity
@Table(name="taches", catalog = "gestionactivities")
public class Tach implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idTache;

	private String datedTache;

	private String datefTache;

	private String descriptionTache;

	private BigInteger idProjet;

	private String nomTache;

	private String statutTache;

	public Tach() {
	}

	public String getIdTache() {
		return this.idTache;
	}

	public void setIdTache(String idTache) {
		this.idTache = idTache;
	}

	public String getDatedTache() {
		return this.datedTache;
	}

	public void setDatedTache(String datedTache) {
		this.datedTache = datedTache;
	}

	public String getDatefTache() {
		return this.datefTache;
	}

	public void setDatefTache(String datefTache) {
		this.datefTache = datefTache;
	}

	public String getDescriptionTache() {
		return this.descriptionTache;
	}

	public void setDescriptionTache(String descriptionTache) {
		this.descriptionTache = descriptionTache;
	}

	public BigInteger getIdProjet() {
		return this.idProjet;
	}

	public void setIdProjet(BigInteger idProjet) {
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

}