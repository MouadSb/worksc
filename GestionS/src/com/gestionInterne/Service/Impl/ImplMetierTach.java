package com.gestionInterne.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gestionInterne.DAO.entity.Tach;
import com.gestionInterne.DAO.intDAO.InterfaceTach;
import com.gestionInterne.Service.Interface.InterfaceMetierTach;

@Component
public class ImplMetierTach implements InterfaceMetierTach {

	@Autowired
	private InterfaceTach it;
	
	public void setIt(InterfaceTach it) {
		this.it = it;
	}

	@Override
	public Tach addTach(Tach p) {
		return it.addTach(p);
	}

	@Override
	public void deleteTach(Tach p) {
		it.deleteTach(p);
	}

	@Override
	public Tach updateTach(Tach p) {
		return it.updateTach(p);
	}

	@Override
	public Tach getTach(int idTach) {
		return it.getTach(idTach);
	}

	@Override
	public List<Tach> getAllTach() {
		return it.getAllTach();
	}

	@Override
	public List<Tach> getAllTachByidP(int id) {
		return it.getAllTachByidP(id);
	}

	@Override
	public List<Tach> getAllTachByidU(int id) {
		return it.getAllTachByidU(id);
	}

	

}
