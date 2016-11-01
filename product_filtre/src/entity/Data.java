package entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the data database table.
 * 
 */
@Entity
public class Data implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String categorie;

	private String description;

	private String indexation;

	private String marque;

	@Column(name="nom_produit")
	private String nomProduit;

	private String prix;

	private String prixnonreduis;

	@Column(name="sous_categorie")
	private String sousCategorie;

	private String url;

	public Data() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIndexation() {
		return this.indexation;
	}

	public void setIndexation(String indexation) {
		this.indexation = indexation;
	}

	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getNomProduit() {
		return this.nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getPrix() {
		return this.prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getPrixnonreduis() {
		return this.prixnonreduis;
	}

	public void setPrixnonreduis(String prixnonreduis) {
		this.prixnonreduis = prixnonreduis;
	}

	public String getSousCategorie() {
		return this.sousCategorie;
	}

	public void setSousCategorie(String sousCategorie) {
		this.sousCategorie = sousCategorie;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Data(int id, String categorie, String description,
			String indexation, String marque, String nomProduit, String prix,
			String prixnonreduis, String sousCategorie, String url) {
		super();
		this.id = id;
		this.categorie = categorie;
		this.description = description;
		this.indexation = indexation;
		this.marque = marque;
		this.nomProduit = nomProduit;
		this.prix = prix;
		this.prixnonreduis = prixnonreduis;
		this.sousCategorie = sousCategorie;
		this.url = url;
	}

	public Data(String categorie, String description, String indexation,
			String marque, String nomProduit, String prix,
			String prixnonreduis, String sousCategorie, String url) {
		super();
		this.categorie = categorie;
		this.description = description;
		this.indexation = indexation;
		this.marque = marque;
		this.nomProduit = nomProduit;
		this.prix = prix;
		this.prixnonreduis = prixnonreduis;
		this.sousCategorie = sousCategorie;
		this.url = url;
	}
	
	

}