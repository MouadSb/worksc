package com.gestionInterne.Service.Interface;


import java.util.List;

import com.gestionInterne.DAO.entity.User;



public interface UserInterfaceMetier {

	public User addUser(User user);

	public void deleteUser(User user);

	public User updateUser(User user);

	public User getUser(String id);

	public List<User> getAllUser();
}
