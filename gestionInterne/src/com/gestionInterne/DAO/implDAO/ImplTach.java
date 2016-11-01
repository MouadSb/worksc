package com.gestionInterne.DAO.implDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.gestionInterne.DAO.entity.Tach;
import com.gestionInterne.DAO.intDAO.InterfaceTach;

public class ImplTach implements InterfaceTach{

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
	public Tach addTach(Tach p) {
		return null;
	}

	@Override
	public void deleteTach(Tach p) {
	}

	@Override
	public Tach updateTach(Tach p) {
		return null;
	}

	@Override
	public Tach getTach(String idTach) {
		return null;
	}

	@Override
	public List<Tach> getAllTach() {
		return null;
	}
}
