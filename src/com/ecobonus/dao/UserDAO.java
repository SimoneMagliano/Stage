package com.ecobonus.dao;

import java.util.List;

import com.ecobonus.entity.User;

public interface UserDAO {
	public List<User> getList();
	public void saveUser(User theUser);
	public User getUser(int theIdUtente);
	public void deleteUser(int theIdUtente);
}
