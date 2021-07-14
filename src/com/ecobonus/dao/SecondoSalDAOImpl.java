package com.ecobonus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.ecobonus.entity.Intervento;
import com.ecobonus.entity.SecondoSal;

@Repository
public class SecondoSalDAOImpl implements SecondoSalDAO {
	@Autowired 
	private SessionFactory sessionFactory;
	public List<SecondoSal> getList() {
		Session currentSession = sessionFactory.getCurrentSession();
			Query<SecondoSal> theQuery = 
					currentSession.createQuery("from SecondoSal order by idSecondoSal", SecondoSal.class);
					List<SecondoSal> secondoSal = theQuery.getResultList();	
				return secondoSal;
	}
	
	@Override
	public void saveSecondoSal(SecondoSal theSecondoSal) {
			Session currentSession = sessionFactory.getCurrentSession();
				currentSession.saveOrUpdate(theSecondoSal);
	}
	
	@Override
	public SecondoSal getSecondoSal(Intervento intervento) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<SecondoSal> theQuery = 
					currentSession.createQuery("from SecondoSal where idIntervento=:idIntervento", SecondoSal.class);
			SecondoSal secondoSal = theQuery.uniqueResult();
			if(secondoSal==null) {
				secondoSal = new SecondoSal();
				secondoSal.setIntervento(intervento);
			}
					return secondoSal;
	}
	@Override
	public void deleteSecondoSal(int theIdSecondoSal) {
	
		Session currentSession = sessionFactory.getCurrentSession();
			Query theQuery = 
					currentSession.createQuery("delete from SecondoSal where idSecondoSal=:idSecondoSal");
					theQuery.setParameter("idSecondoSal", theIdSecondoSal);
					theQuery.executeUpdate();		
	}

}
