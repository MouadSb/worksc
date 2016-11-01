package com.gestionInterne.Service.Interface;

import java.util.List;

import com.gestionInterne.DAO.entity.Module;


public interface InterfaceMetierModule {

	public Module addModule(Module p);

	public void deleteModule(Module p);

	public Module updateModule(Module p);

	public Module getModule(int idModule);

	public List<Module> getAllModule();
}
