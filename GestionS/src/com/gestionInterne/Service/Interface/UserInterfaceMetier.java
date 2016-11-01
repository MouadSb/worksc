package com.gestionInterne.Service.Interface;


import java.util.List;

import com.gestionInterne.DAO.entity.User;



public interface UserInterfaceMetier {

	public User addUser(User user);

	public void deleteUser(User user);

	public User updateUser(User user);

	public User getUserById(int id);
	
	public User getUser(String username);

	public List<User> getAllUser();
	
	public User getUserByfullName(String nom, String prenom);

}
