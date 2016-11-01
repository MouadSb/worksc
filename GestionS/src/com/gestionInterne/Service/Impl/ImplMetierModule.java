package com.gestionInterne.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionInterne.DAO.entity.Module;
import com.gestionInterne.DAO.intDAO.InterfaceModule;
import com.gestionInterne.Service.Interface.InterfaceMetierModule;

@Service
public class ImplMetierModule implements InterfaceMetierModule {

	
	@Autowired
	private InterfaceModule DAOModule;
	
	public void setDAOModule(InterfaceModule dAOModule) {
		DAOModule = dAOModule;
	}

	@Override
	public Module addModule(Module p) {
		return DAOModule.addModule(p);
	}

	@Override
	public void deleteModule(Module p) {
		DAOModule.deleteModule(p);
	}

	@Override
	public Module updateModule(Module p) {
		return DAOModule.updateModule(p);
	}

	@Override
	public Module getModule(int idModule) {
		return DAOModule.getModule(idModule);
	}

	@Override
	public List<Module> getAllModule() {
		return DAOModule.getAllModule();
	}

}
