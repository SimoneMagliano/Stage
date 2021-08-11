package com.ecobonus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ecobonus.dao.UserDAO;
import com.ecobonus.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
		@Autowired
		private UserDAO userDAO;
		
		@Override
		@Transactional
		public List<User> getList() {
			return userDAO.getList();
		}

		@Override
		@Transactional
		public User getUser(int theIdUtente) {		
			return userDAO.getUser(theIdUtente);
		}

		@Override
		@Transactional
		public User getUser(String email, String password) {		
			return userDAO.getUser(email, password);
		}

		@Override
		@Transactional
		public void saveUser(User user) {
			userDAO.saveUser(user);		
		}
		
		@Override
		@Transactional
		public void deleteUser(int theIdUtente) {
			userDAO.deleteUser(theIdUtente);		
		}
	}


