package com.gestionInterne.DAO.implDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.gestionInterne.DAO.entity.User;
import com.gestionInterne.DAO.entity.UserRole;
import com.gestionInterne.DAO.intDAO.UserRoleInterface;


public class UserRoleImpl implements UserRoleInterface {

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
	public UserRole addUserRole(UserRole userRole) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(userRole);
		getEntityManager().getTransaction().commit();
		return userRole;
	}

	@Override
	public void deleteUserRole(UserRole userRole) {
		getEntityManager().getTransaction().begin();
		userRole = getEntityManager().merge(userRole);// <-Important
		getEntityManager().remove(userRole);
		getEntityManager().getTransaction().commit();
	}

	@Override
	public UserRole updateUserRole(UserRole userRole) {
		getEntityManager().getTransaction().begin();
		userRole = getEntityManager().merge(userRole);
		getEntityManager().getTransaction().commit();
		return userRole;
	}

	@Override
	public UserRole getUserRole(long id_userRole) {
		return getEntityManager().find(UserRole.class, id_userRole);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getAllUserRole() {
		List<UserRole> userRole = getEntityManager().createQuery(
				"select p from UserRole p").getResultList();
		return userRole;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllRoles() {
		List<String> roles = getEntityManager().createQuery(
				"select DISTINCT p.role from UserRole p").getResultList();
		return roles;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserRole getUserRoled(User user) {

		UserRole userr = new UserRole();
		List<UserRole> res = getEntityManager().createQuery(
				"select u FROM UserRole u").getResultList();
		for (UserRole userRole : res) {
			if (userRole.getUser().getUsername().compareTo(user.getUsername()) == 0) {
				userr = userRole;
			}
		}
		return userr;
	}

}
