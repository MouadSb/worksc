package com.gestionInterne.DAO.intDAO;

import java.util.List;

import com.gestionInterne.DAO.entity.User;



public interface UserInterface {

	public User addUser(User user);

	public void deleteUser(User user);

	public User updateUser(User user);

	public User getUserById(int id_user);

	public List<User> getAllUser();

	public User getUser(String id_user);

	public User getUserByfullName(String nom, String prenom);
}
