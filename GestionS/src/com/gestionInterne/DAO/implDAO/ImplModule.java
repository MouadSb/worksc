package com.gestionInterne.DAO.implDAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestionInterne.DAO.entity.Module;
import com.gestionInterne.DAO.intDAO.InterfaceModule;


@Repository("DAOModule")
@Transactional
public class ImplModule implements InterfaceModule{

	@Autowired
    private SessionFactory sessionFactory;
 
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public Module addModule(Module p) {
		sessionFactory.getCurrentSession().save(p);
		return p;
	}

	@Override
	public void deleteModule(Module p) {
		sessionFactory.getCurrentSession().delete(p);
	}

	@Override
	public Module updateModule(Module p) {
		sessionFactory.getCurrentSession().update(p);
		return p;
	}

	@Override
	public Module getModule(int idModule) {
		return (Module) sessionFactory.getCurrentSession().get(Module.class,idModule );
	}

	@Override
	public List<Module> getAllModule() {
		@SuppressWarnings("unchecked")
		List<Module> p = sessionFactory.getCurrentSession().createCriteria(Module.class).list();
		return p;
	}

}
