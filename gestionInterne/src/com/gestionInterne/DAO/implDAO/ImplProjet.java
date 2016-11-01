package com.gestionInterne.DAO.implDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.gestionInterne.DAO.entity.Projet;
import com.gestionInterne.DAO.intDAO.InterfaceProjet;

public class ImplProjet implements InterfaceProjet{

	private static final String JPA_UNIT_NAME = "gestionInterne";

	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory(
					JPA_UNIT_NAME).createEntityManager();
		}
		return entityManager;
	}

	@Override
	public Projet addProjet(Projet p) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(p);
		getEntityManager().getTransaction().commit();
		return p;
	}

	@Override
	public void deleteProjet(Projet p) {
		getEntityManager().getTransaction().begin();
		p = getEntityManager().merge(p);// <-Important
		getEntityManager().remove(p);
		getEntityManager().getTransaction().commit();
	}

	@Override
	public Projet updateProjet(Projet p) {
		getEntityManager().getTransaction().begin();
		p = getEntityManager().merge(p);
		getEntityManager().getTransaction().commit();
		return p;
	}

	@Override
	public Projet getProjet(String idProjet) {
		return getEntityManager().find(Projet.class,idProjet );
	}

	@Override
	public List<Projet> getAllProjet() {
		@SuppressWarnings("unchecked")
		List<Projet> p = getEntityManager().createQuery(
				"select p from Projet p").getResultList();
		return p;
	}
	
}
