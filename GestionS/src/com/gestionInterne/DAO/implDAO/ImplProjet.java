package com.gestionInterne.DAO.implDAO;

import java.util.List;




import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestionInterne.DAO.entity.Projet;
import com.gestionInterne.DAO.intDAO.InterfaceProjet;

@Repository("ip")
@Transactional
public class ImplProjet implements InterfaceProjet{

	@Autowired
    private SessionFactory sessionFactory;
 
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public Projet addProjet(Projet p) {
		sessionFactory.getCurrentSession().save(p);
		return p;
	}

	@Override
	public void deleteProjet(Projet p) {
		sessionFactory.getCurrentSession().delete(p);
	}

	@Override
	public Projet updateProjet(Projet p) {
		sessionFactory.getCurrentSession().update(p);
		return p;
	}

	@Override
	public Projet getProjet(int idProjet) {
		return (Projet) sessionFactory.getCurrentSession().get(Projet.class,idProjet );
	}

	@Override
	public List<Projet> getAllProjet() {
		@SuppressWarnings("unchecked")
		List<Projet> p = sessionFactory.getCurrentSession().createCriteria(Projet.class).list();
		return p;
	}
	
	@Override
	public List<Projet> getAllProjetbyName(int idname) {
		@SuppressWarnings("unchecked")
		List<Projet> p = sessionFactory.getCurrentSession().createCriteria(Projet.class).add(Restrictions.eq("idUser", idname)).list();
		return p;
	}
	
	@Override
	public List<Projet> getAllProjetbyChef(int idname) {
		@SuppressWarnings("unchecked")
		List<Projet> p = sessionFactory.getCurrentSession().createCriteria(Projet.class).add(Restrictions.eq("idUser", idname)).list();
		return p;
	}
	
}
