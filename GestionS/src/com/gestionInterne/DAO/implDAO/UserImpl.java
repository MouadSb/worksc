package com.gestionInterne.DAO.implDAO;

import java.util.List;




import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestionInterne.DAO.entity.User;
import com.gestionInterne.DAO.intDAO.UserInterface;


@Repository("userDAO")
@Transactional
public class UserImpl implements UserInterface {

	@Autowired
    private SessionFactory sessionFactory;
 
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public User addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user;
	}

	@Override
	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	public User updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return user;
	}

	@Override
	public User getUser(String id_user) {
		return (User) sessionFactory.getCurrentSession().get(User.class,id_user );
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User getUserById(int username) {
		List<User> p = sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("id", username)).list();

		return p.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByfullName(String nom, String prenom) {
		
		Criterion salary = Restrictions.ilike("nom", nom);
		Criterion name = Restrictions.ilike("prenom",prenom);
		LogicalExpression andExp = Restrictions.and(salary, name);
		List<User> p = sessionFactory.getCurrentSession().createCriteria(User.class).add(andExp).list();
		return p.get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		List<User> p = sessionFactory.getCurrentSession().createCriteria(User.class).list();
		return p;
	}

}
