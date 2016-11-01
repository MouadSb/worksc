package com.gestionInterne.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestionInterne.DAO.entity.Tach;
import com.gestionInterne.DAO.intDAO.InterfaceTach;
import com.gestionInterne.Service.Interface.InterfaceMetierTach;

@Service
public class ImplMetierTach implements InterfaceMetierTach {

	
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
	public Tach getTach(String idTach) {
		return it.getTach(idTach);
	}

	@Override
	public List<Tach> getAllTach() {
		return it.getAllTach();
	}

	

}
