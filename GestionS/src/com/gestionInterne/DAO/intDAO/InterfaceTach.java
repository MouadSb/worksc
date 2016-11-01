package com.gestionInterne.DAO.intDAO;

import java.util.List;

import com.gestionInterne.DAO.entity.Tach;

public interface InterfaceTach {

	public Tach addTach(Tach p);

	public void deleteTach(Tach p);

	public Tach updateTach(Tach p);

	public Tach getTach(int idTach);

	public List<Tach> getAllTach();
	
	public List<Tach> getAllTachByidP(int id);
	
	public List<Tach> getAllTachByidU(int id);

}
