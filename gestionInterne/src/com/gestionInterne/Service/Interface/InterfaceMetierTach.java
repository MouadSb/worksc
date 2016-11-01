package com.gestionInterne.Service.Interface;

import java.util.List;

import com.gestionInterne.DAO.entity.Tach;

public interface InterfaceMetierTach {

	
	public Tach addTach(Tach p);

	public void deleteTach(Tach p);

	public Tach updateTach(Tach p);

	public Tach getTach(String idTach);

	public List<Tach> getAllTach();
	
}
