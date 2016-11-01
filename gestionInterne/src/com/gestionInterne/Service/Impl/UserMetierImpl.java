package com.gestionInterne.Service.Impl;



import java.util.List;

import org.springframework.stereotype.Service;

import com.gestionInterne.DAO.entity.User;
import com.gestionInterne.DAO.intDAO.UserInterface;
import com.gestionInterne.Service.Interface.UserInterfaceMetier;


@Service
public class UserMetierImpl implements UserInterfaceMetier {

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
	public User getUser(String id_user) {
		return userDAO.getUser(id_user);
	}

	@Override
	public List<User> getAllUser() {
		return userDAO.getAllUser();
	}

}
