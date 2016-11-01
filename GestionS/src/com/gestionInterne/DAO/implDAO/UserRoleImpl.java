package com.gestionInterne.DAO.implDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestionInterne.DAO.entity.User;
import com.gestionInterne.DAO.entity.UserRole;
import com.gestionInterne.DAO.intDAO.UserRoleInterface;

@Repository("userRoleDAO")
@Transactional
public class UserRoleImpl implements UserRoleInterface {

	@Autowired
    private SessionFactory sessionFactory;
 
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public UserRole addUserRole(UserRole userRole) {
		sessionFactory.getCurrentSession().save(userRole);
		return userRole;
	}

	@Override
	public void deleteUserRole(UserRole userRole) {
		sessionFactory.getCurrentSession().delete(userRole);
	}

	@Override
	public UserRole updateUserRole(UserRole userRole) {
		sessionFactory.getCurrentSession().update(userRole);
		return userRole;
	}

	@Override
	public UserRole getUserRole(long id_userRole) {
		return (UserRole) sessionFactory.getCurrentSession().get(UserRole.class,id_userRole );
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getAllUserRole() {

		List<UserRole> userRole = sessionFactory.getCurrentSession().createCriteria(UserRole.class).list();
		return userRole;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllRoles() {
		//List<String> roles = getEntityManager().createQuery("select DISTINCT p.role from UserRole p").getResultList();
		
		Query query=sessionFactory.getCurrentSession().createQuery("select DISTINCT p.role from UserRole p");
		List<String> roles = query.list();
		return roles;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserRole getUserRoled(User user) {

		UserRole userr = new UserRole();
		List<UserRole> res = sessionFactory.getCurrentSession().createCriteria(UserRole.class).list();	
		for (UserRole userRole : res) {
			if (userRole.getUser().getUsername().compareTo(user.getUsername()) == 0) {
				userr = userRole;
			}
		}
		return userr;
	}

}
