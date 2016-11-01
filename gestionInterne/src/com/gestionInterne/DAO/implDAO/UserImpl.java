package com.gestionInterne.DAO.implDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.gestionInterne.DAO.entity.User;
import com.gestionInterne.DAO.intDAO.UserInterface;



public class UserImpl implements UserInterface {

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
	public User addUser(User user) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(user);
		getEntityManager().getTransaction().commit();
		return user;
	}

	@Override
	public void deleteUser(User user) {
		getEntityManager().getTransaction().begin();
		user = getEntityManager().merge(user);
		getEntityManager().remove(user);
		getEntityManager().getTransaction().commit();
	}

	@Override
	public User updateUser(User user) {
		getEntityManager().getTransaction().begin();
		user = getEntityManager().merge(user);
		getEntityManager().getTransaction().commit();
		return user;
	}

	@Override
	public User getUser(String id_user) {
		return getEntityManager().find(User.class, id_user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		List<User> user = getEntityManager().createQuery(
				"select p from User p").getResultList();
		return user;
	}

}
