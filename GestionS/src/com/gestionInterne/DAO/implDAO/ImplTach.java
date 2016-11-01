package com.gestionInterne.DAO.implDAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestionInterne.DAO.entity.Projet;
import com.gestionInterne.DAO.entity.Tach;
import com.gestionInterne.DAO.intDAO.InterfaceTach;

@Repository("it")
@Transactional
public class ImplTach implements InterfaceTach{

	@Autowired
    private SessionFactory sessionFactory;
 
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public Tach addTach(Tach p) {
		sessionFactory.getCurrentSession().save(p);
		return p;
	}

	@Override
	public void deleteTach(Tach p) {
		sessionFactory.getCurrentSession().delete(p);
	}

	@Override
	public Tach updateTach(Tach p) {
		sessionFactory.getCurrentSession().update(p);
		return p;
	}

	@Override
	public Tach getTach(int idTach) {
		return (Tach) sessionFactory.getCurrentSession().get(Tach.class,idTach );
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tach> getAllTach() {
		List<Tach> p = sessionFactory.getCurrentSession().createCriteria(Tach.class).list();
		return p;
	}
	
	@Override
	public List<Tach> getAllTachByidP(int id) {
		@SuppressWarnings("unchecked")
		List<Tach> p = sessionFactory.getCurrentSession().createCriteria(Tach.class).add(Restrictions.eq("idProjet", id)).list();
		return p;
		
	}
	
	@Override
	public List<Tach> getAllTachByidU(int id) {
		@SuppressWarnings("unchecked")
		List<Tach> p = sessionFactory.getCurrentSession().createCriteria(Tach.class).add(Restrictions.eq("idUser", id)).list();
		return p;
		
	}
}
