package com.ecobonus.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecobonus.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired 
	private SessionFactory sessionFactory;
	
@Override
public List<User> getList() {
		Session currentSession = sessionFactory.getCurrentSession();
			Query<User> theQuery = 
					currentSession.createQuery("from User order by nome", User.class);
					List<User> users = theQuery.getResultList();	
				return users;
}

@Override
public void saveUser(User theUser) {
		Session currentSession = sessionFactory.getCurrentSession();
			currentSession.saveOrUpdate(theUser);
}

@Override
public User getUser(int theIdUtente) {
		Session currentSession = sessionFactory.getCurrentSession();
			User theUser = currentSession.get(User.class, theIdUtente);
				return theUser;
}

@Override
public User getUser(String email, String password) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> query = currentSession.createQuery("from User where email = :email and password = :password", User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);	
		User user = null;
		try {
			user = query.getSingleResult();	
		} catch (NoResultException e){
			return null;
		}

		return user;
}

@Override
public void deleteUser(int idUtente) {
		Session currentSession = sessionFactory.getCurrentSession();
			Query theQuery = 
					currentSession.createQuery("delete from User where idUtente=:idUtente");
					theQuery.setParameter("idUtente", idUtente);
					theQuery.executeUpdate();		
}
}
