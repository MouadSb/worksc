package com.gestionInterne.DAO.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the modules database table.
 * 
 */
@Entity
@Table(name="modules")
@NamedQuery(name="Module.findAll", query="SELECT m FROM Module m")
public class Module implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idModule;

	private String nomModule;

	public Module() {
	}

	public int getIdModule() {
		return this.idModule;
	}

	public void setIdModule(int idModule) {
		this.idModule = idModule;
	}

	public String getNomModule() {
		return this.nomModule;
	}

	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}

}