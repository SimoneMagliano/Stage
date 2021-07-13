package com.ecobonus.service;

import java.util.List;

import com.ecobonus.entity.User;

public interface UserService {
	public List<User> getList();
	public void saveUser(User theUser);
	public User getUser(int theIdUtente);
	public void deleteUser(int theIdUtente);
}
