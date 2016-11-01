package com.gestionInterne.Service.Impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gestionInterne.DAO.entity.User;
import com.gestionInterne.DAO.intDAO.UserInterface;
import com.gestionInterne.Service.Interface.UserInterfaceMetier;


@Component
public class UserMetierImpl implements UserInterfaceMetier {

	@Autowired
	private UserInterface userDAO;
	
	public void setUserDAO(UserInterface userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User addUser(User user) {
		return userDAO.addUser(user);
	}

	@Override
	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}

	@Override
	public User updateUser(User user) {
		return userDAO.updateUser(user);
	}

	@Override
	public User getUserById(int id_user) {
		return userDAO.getUserById(id_user);
	}

	@Override
	public List<User> getAllUser() {
		return userDAO.getAllUser();
	}

	@Override
	public User getUser(String username) {
		return userDAO.getUser(username);
	}

	@Override
	public User getUserByfullName(String nom, String prenom) {
		return userDAO.getUserByfullName(nom, prenom);
	}

}
